package com.carlsonwagonlit.linedef;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Value("classpath:linedefs-dupe-id.json")
    private URL dupeIdJson;

    @Test
    public void rejectDupeIds() throws IOException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Duplicate LineDef found");
        new LineDefRepo(dupeIdJson);
    }

    @Value("classpath:linedefs-dupe-source.json")
    private URL dupeSourceJson;

    @Test
    public void rejectDupeSources() throws IOException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("has a duplicate sourceId");
        new LineDefRepo(dupeSourceJson);
    }

    @Value("classpath:linedefs-no-id.json")
    private URL noIdJson;

    @Test
    public void rejectNoId() throws IOException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Failed requirement.");
        new LineDefRepo(noIdJson);
    }

    @Value("classpath:linedefs-no-source.json")
    private URL noSourceJson;

    @Test
    public void rejectNoSource() throws IOException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("has field with empty 'sourceId'");
        new LineDefRepo(noSourceJson);
    }

    @Value("classpath:linedefs-unknown-key.json")
    private URL unknownKeyJson;

    @Test(expected = UnrecognizedPropertyException.class)
    public void rejectUnknownKey() throws IOException {
        new LineDefRepo(unknownKeyJson);
    }

}
