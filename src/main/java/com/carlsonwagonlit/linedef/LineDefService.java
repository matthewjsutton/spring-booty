package com.carlsonwagonlit.linedef;

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

    //private final FooProperties propey
    // rties;

//    @Autowired
//    public MyService(FooProperties properties) {
//        //this.properties = properties;


    @PostConstruct
    public void postConstruct() throws IOException {
        LOG.info("post construct");
        URL resource = Resources.getResource("linedefs.json");
//        String string = Resources.toString(resource, Charsets.UTF_8);
//        LOG.info("Hello, here's my file=" + string);


        //        File file = new ClassPathResource("linedefs.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        LineDefs lineDefs = mapper.readValue(resource, LineDefs.class);
        LOG.info("Now my linedefs=" + lineDefs);
    }

    private static class LineDefs {
        public List<LineDef> list;

        @Override
        public String toString() {
            return "LineDefs{" +
                    "list=" + list +
                    '}';
        }
    }

}
