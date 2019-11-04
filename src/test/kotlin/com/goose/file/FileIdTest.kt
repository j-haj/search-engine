package com.goose.file

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.assertNull
import org.junit.Test

class FileIdTest {
    @Test
    fun `test fileId sequence`() {
        val f1 = FileId.issueFileId("/test/path1")
        val f2 = FileId.issueFileId("/test/path2")
        assertTrue(f1.id != f2.id)
    }

    @Test
    fun `test FileId lookup`() {
        val path1 = "/test/path/1"
        val path2 = "/test/path/2"
        val f1 = FileId.issueFileId(path1)
        val f2 = FileId.issueFileId(path2)
        assertEquals(f1, FileId.lookupFileIdForPath(path1))
        assertEquals(f2, FileId.lookupFileIdForPath(path2))
    }

    @Test
    fun `text missing path lookup is null`() {
        val f = FileId.lookupFileIdForPath("/missing/path")
        assertNull(f)
    }
}
