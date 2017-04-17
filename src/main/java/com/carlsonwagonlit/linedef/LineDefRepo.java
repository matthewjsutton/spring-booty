package com.carlsonwagonlit.linedef;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Repository for the LineDefs defined in the JSON file
 */
@Repository
class LineDefRepo {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final Map<LineDefId, LineDef> lineDefMap;

    @Autowired
    LineDefRepo(@Value("classpath:linedefs.json") URL lineDefResource) throws IOException {
        TypeReference<List<LineDef>> typeRef = new TypeReference<List<LineDef>>() {
        };
        ObjectMapper mapper = new ObjectMapper();
        List<LineDef> lineDefs = mapper.readValue(lineDefResource, typeRef);

        LOG.info("lineDefs=" + lineDefs);

        LinkedHashMap<LineDefId, LineDef> map = new LinkedHashMap<>(lineDefs.size());
        for (LineDef lineDef : lineDefs) {
            LineDefId id = new LineDefId(lineDef.getSubGuidId(), lineDef.getGdsId());
            map.put(id, lineDef);
        }

        lineDefMap = Collections.unmodifiableMap(map);
    }

    int size() {
        return lineDefMap.size();
    }

    Optional<LineDef> lineDef(String subGuidId, String gdsId) {
        LineDef lineDef = lineDefMap.get(new LineDefId(subGuidId, gdsId));
        return Optional.ofNullable(lineDef);
    }

    private static class LineDefId {
        private final String subGuidId;
        private final String gdsId;

        private LineDefId(String subGuidId, String gdsId) {
            this.subGuidId = subGuidId;
            this.gdsId = gdsId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LineDefId lineDefId = (LineDefId) o;

            if (!subGuidId.equals(lineDefId.subGuidId)) return false;
            return gdsId.equals(lineDefId.gdsId);
        }

        @Override
        public int hashCode() {
            int result = subGuidId.hashCode();
            result = 31 * result + gdsId.hashCode();
            return result;
        }
    }
}
