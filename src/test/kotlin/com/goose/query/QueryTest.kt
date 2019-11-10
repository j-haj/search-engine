package com.goose.query

import org.junit.Assert.assertEquals
import org.junit.Test

class QueryTest {
    @Test
    fun testTerms() {
        val q = Query("This is a test. It doesn't contain a SiMPle query!??")
        val expected = listOf("this", "is", "a", "test", "it", "doesnt", "contain", "a",
                              "simple", "query")
        val actual = q.terms()
        assertEquals(expected, actual)
    }
}
