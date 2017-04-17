package com.carlsonwagonlit.linedef;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

/**
 * Repository for the LineDefs defined in the JSON file
 */
@Repository
public class LineDefRepo {
    private static final TypeReference<ArrayList<LineDef>> TYPE_LIST_LINEDEF = new TypeReference<ArrayList<LineDef>>() {
    };
    private static final ObjectMapper mapper = new ObjectMapper();
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Value("classpath:linedefs.json")
    private URL lineDefResource;

    private ArrayList<LineDef> lineDefs;
    private LinkedHashMap<LineDefId, LineDef> lineDefMap;

    @PostConstruct
    private void initialize() throws IOException {
//        URL resource = Resources.getResource("linedefs.json");
//        String string = Resources.toString(resource, Charsets.UTF_8);
        //        File file = new ClassPathResource("linedefs.json").getFile();

        lineDefs = mapper.readValue(lineDefResource, TYPE_LIST_LINEDEF);
        LOG.info("lineDefs=" + lineDefs);

        lineDefMap = new LinkedHashMap<>(lineDefs.size());
        for (LineDef lineDef : lineDefs) {
            LineDefId id = new LineDefId(lineDef.getSubGuidId(), lineDef.getGdsId());
            lineDefMap.put(id, lineDef);
        }
    }

    public List<LineDef> lineDefs() {
        return Collections.unmodifiableList(lineDefs);
    }

    public Optional<LineDef> lineDef(String subGuidId, String gdsId) {
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
