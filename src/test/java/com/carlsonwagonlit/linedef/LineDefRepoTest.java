package com.carlsonwagonlit.linedef;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URL;

/**
 * Test the LineDefRepo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LineDefRepoTest {
    @Autowired
    private LineDefRepo repo;

    @Test
    public void parseJson() {
        Assert.assertTrue("Repo should have content", repo.size() > 0);
    }

    @Value("classpath:linedefs-dupe.json")
    private URL dupeJson;

    @Test(expected = IllegalArgumentException.class)
    public void rejectJsonWithDupes() throws IOException {
        new LineDefRepo(dupeJson);
    }

    @Value("classpath:linedefs-invalid-element.json")
    private URL invalidElementJson;

    @Test(expected = UnrecognizedPropertyException.class)
    public void rejectInvalidElement() throws IOException {
        new LineDefRepo(invalidElementJson);
    }

}
