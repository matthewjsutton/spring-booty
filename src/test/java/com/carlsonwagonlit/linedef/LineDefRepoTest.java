package com.carlsonwagonlit.linedef;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;

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
        Assert.assertFalse("Repo has content", repo.lineDefs().isEmpty());
    }
}
