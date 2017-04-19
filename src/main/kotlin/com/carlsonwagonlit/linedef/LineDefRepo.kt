package com.carlsonwagonlit.linedef

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository
import java.net.URL
import java.util.Collections
import java.util.Optional


/**
 * Repository for the LineDefs defined in the JSON file
 */
@Repository
class LineDefRepo(@Value("classpath:linedefs.json") private val lineDefResource: URL) {
    private val LOG = LoggerFactory.getLogger(javaClass)

    private val lineDefMap = initLineDefMap()

    private fun initLineDefMap(): Map<LineDefId, LineDef> {
        val typeRef = object : TypeReference<List<LineDef>>() {}
        val mapper = ObjectMapper()

        // If we want the flexibility to add new fields at the cost of compile-time check:
        // 1) remove unit test "rejectUnknownKey"
        // 2) uncomment line below
//        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)

        val lineDefs: List<LineDef> = mapper.readValue(lineDefResource, typeRef)

        LOG.info("lineDefs=" + lineDefs)

        val map = LinkedHashMap<LineDefId, LineDef>(lineDefs.size)
        lineDefs.forEach {
            if (it.subGuidId.isEmpty() || it.gdsId.isEmpty()) {
                throw IllegalArgumentException("'subGuidId' and 'gdsId' cannot be empty")
            }
            val id = LineDefId(it.subGuidId, it.gdsId)
            val prev = map.put(id, it)
            if (prev != null) {
                throw IllegalArgumentException("Duplicate LineDef found, id=$id")
            }
            val sources: List<String> = it.fields.map { it.source }
            if (sources.any(String::isEmpty)) {
                throw IllegalArgumentException("LineDef id=$id has field with empty 'source'")
            }
            if (sources.size != HashSet(sources).size) {
                throw IllegalArgumentException("LineDef id=$id has a duplicate source")
            }
        }

        LOG.info("LineDefs parsed=${map.size}")

        return Collections.unmodifiableMap(map)
    }

    fun size(): Int = lineDefMap.size

    fun lineDef(subGuidId: String, gdsId: String): Optional<LineDef> {
        val id = LineDefId(subGuidId, gdsId)
        return Optional.ofNullable(lineDefMap[id])
    }

    private data class LineDefId(val subGuidId: String, val gdsId: String)
}

