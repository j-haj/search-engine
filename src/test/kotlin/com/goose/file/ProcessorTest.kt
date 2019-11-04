package com.goose.file

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ProcessorTest {

    @Test fun `process simple input`() {
        val p = DefaultProcessor()
        val phrase = "Test text. Don't want - punctuation; or empty string! RiGhT?"
        val expected = listOf("test", "text", "dont", "want", "punctuation", "or", "empty", "string", "right")
        assertEquals("token lists are not equal", expected, p.process(phrase))

    }
}
