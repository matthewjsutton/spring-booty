package com.carlsonwagonlit.linedef;

import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.annotation.*;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Repository for the LineDefs defined in the JSON file
 */
@Repository
public class LineDefRepo {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private static final TypeReference<ArrayList<LineDef>> TYPE_LIST_LINEDEF = new TypeReference<ArrayList<LineDef>>() {
    };
    private static final ObjectMapper mapper = new ObjectMapper();

    @Value("classpath:linedefs.json")
    private URL lineDefResource;

    private ArrayList<LineDef> lineDefs;

    @PostConstruct
    private void initialize() throws IOException {
//        URL resource = Resources.getResource("linedefs.json");
//        String string = Resources.toString(resource, Charsets.UTF_8);
        //        File file = new ClassPathResource("linedefs.json").getFile();

        lineDefs = mapper.readValue(lineDefResource, TYPE_LIST_LINEDEF);
        LOG.info("lineDefs=" + lineDefs);
    }

    public List<LineDef> lineDefs() {
        return Collections.unmodifiableList(lineDefs);
    }

    public Optional<LineDef> lineDef(String subGuidId, String gdsId) {
        return Optional.empty();
    }

}
