package com.carlsonwagonlit.linedef;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        Assert.assertTrue("Repo does not have content", repo.size() > 0);
    }
}
