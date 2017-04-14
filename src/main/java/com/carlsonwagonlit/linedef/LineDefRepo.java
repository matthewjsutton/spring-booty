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
import java.util.List;

/**
 * Repository for the LineDefs defined in the JSON file
 */
@Repository
public class LineDefRepo {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private static final TypeReference<List<LineDef>> TYPE_LIST_LINEDEF = new TypeReference<List<LineDef>>() {
    };
    private static final ObjectMapper mapper = new ObjectMapper();

    @Value("classpath:linedefs.json")
    private URL lineDefResource;

    private List<LineDef> lineDefs;

    @PostConstruct
    private void initialize() throws IOException {
//        URL resource = Resources.getResource("linedefs.json");
//        String string = Resources.toString(resource, Charsets.UTF_8);
        //        File file = new ClassPathResource("linedefs.json").getFile();

        lineDefs = mapper.readValue(lineDefResource, TYPE_LIST_LINEDEF);
        LOG.info("lineDefs=" + lineDefs);
    }

    public List<LineDef> lineDefs() {
        return lineDefs;
    }

}
