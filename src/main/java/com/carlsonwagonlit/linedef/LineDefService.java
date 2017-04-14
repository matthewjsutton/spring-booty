package com.carlsonwagonlit.linedef;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by U035JXT on 4/13/2017.
 */
@Service
public class LineDefService {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @PostConstruct
    public void postConstruct() throws IOException {
        URL resource = Resources.getResource("linedefs.json");
//        String string = Resources.toString(resource, Charsets.UTF_8);
//        LOG.info("Hello, here's my file=" + string);
        //        File file = new ClassPathResource("linedefs.json").getFile();

        TypeReference<List<LineDef>> listType = new TypeReference<List<LineDef>>() {
        };
        ObjectMapper mapper = new ObjectMapper();
        List<LineDef> lineDefs = mapper.readValue(resource, listType);
        LOG.info("Now my linedefs=" + lineDefs);
    }

}
