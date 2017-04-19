package com.carlsonwagonlit.linedef

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.net.URL

/**
 * Test the LineDefRepo
 */
@RunWith(SpringRunner::class)
@SpringBootTest
class LineDefRepoTest {
    @Autowired
    lateinit var repo: LineDefRepo

    @Test
    fun parseJson() {
        Assert.assertTrue("Repo should have content", repo.size() > 0)
    }

    @Rule
    @JvmField
    val thrown: ExpectedException = ExpectedException.none()

    @Value("classpath:linedefs-dupe-id.json")
    lateinit var dupeIdJson: URL

    @Test
    fun rejectDupeIds() {
        thrown.expect(IllegalArgumentException::class.java)
        thrown.expectMessage("Duplicate LineDef found")
        LineDefRepo(dupeIdJson)
    }

    @Value("classpath:linedefs-dupe-source.json")
    lateinit var dupeSourceJson: URL

    @Test
    fun rejectDupeSources() {
        thrown.expect(IllegalArgumentException::class.java)
        thrown.expectMessage("has a duplicate sourceId")
        LineDefRepo(dupeSourceJson)
    }

    @Value("classpath:linedefs-no-id.json")
    lateinit var noIdJson: URL

    @Test
    fun rejectNoId() {
        thrown.expect(IllegalArgumentException::class.java)
        thrown.expectMessage("Failed requirement.")
        LineDefRepo(noIdJson)
    }

    @Value("classpath:linedefs-no-source.json")
    lateinit var noSourceJson: URL

    @Test
    fun rejectNoSource() {
        thrown.expect(IllegalArgumentException::class.java)
        thrown.expectMessage("has field with empty 'sourceId'")
        LineDefRepo(noSourceJson)
    }

    @Value("classpath:linedefs-unknown-key.json")
    lateinit var unknownKeyJson: URL

    @Test(expected = UnrecognizedPropertyException::class)
    fun rejectUnknownKey() {
        LineDefRepo(unknownKeyJson)
    }

}
