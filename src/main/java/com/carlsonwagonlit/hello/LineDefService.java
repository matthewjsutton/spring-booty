package com.carlsonwagonlit.hello;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

/**
 * Created by U035JXT on 4/13/2017.
 */
@Service
public class LineDefService {
    private static final Logger LOG = LoggerFactory.getLogger(LineDefService.class);

    //private final FooProperties properties;

//    @Autowired
//    public MyService(FooProperties properties) {
//        //this.properties = properties;


    @PostConstruct
    public void openConnection() throws IOException {
        //Server server = new Server(this.properties.getRemoteAddress());
//        File file = new ClassPathResource("linedefs.json").getFile();
        URL resource = Resources.getResource("linedefs.json");
        String string = Resources.toString(resource, Charsets.UTF_8);
        LOG.info("Hello, here's my file=" + string);
    }

}