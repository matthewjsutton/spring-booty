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

    @Value("classpath:linedefs-dupe-id.json")
    private URL dupeIdJson;

    @Test(expected = IllegalArgumentException.class)
    public void rejectDupeIds() throws IOException {
        new LineDefRepo(dupeIdJson);
    }

    @Value("classpath:linedefs-dupe-source.json")
    private URL dupeSourceJson;

    @Test(expected = IllegalArgumentException.class)
    public void rejectDupeSources() throws IOException {
        new LineDefRepo(dupeSourceJson);
    }

    @Value("classpath:linedefs-no-id.json")
    private URL noIdJson;

    @Test(expected = IllegalArgumentException.class)
    public void rejectNoId() throws IOException {
        new LineDefRepo(noIdJson);
    }

    @Value("classpath:linedefs-no-source.json")
    private URL noSourceJson;

    @Test(expected = IllegalArgumentException.class)
    public void rejectNoSource() throws IOException {
        new LineDefRepo(noSourceJson);
    }

    @Value("classpath:linedefs-unknown-key.json")
    private URL unknownKeyJson;

    @Test(expected = UnrecognizedPropertyException.class)
    public void rejectUnknownKey() throws IOException {
        new LineDefRepo(unknownKeyJson);
    }

}
