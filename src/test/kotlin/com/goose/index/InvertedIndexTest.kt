package com.goose.index

import com.goose.file.FileId

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class InvertedIndexTest {
    @Test
    fun `test adding file index`() {
        val index = mapOf("a" to 1L, "b" to 2L, "c" to 3L, "d" to 1L)
        val invertedIndex = InvertedIndex()
        val path = "/test/path/inverted/index/test"
        val fileId = FileId.issueFileId(path)
        invertedIndex.addFileIndex(fileId, index)

        index.forEach {
            k, _ ->
            // Check the word is in the index
            assertTrue(invertedIndex.containsWord(k))
            // Make sure each list has length 1
            assertEquals(1, invertedIndex.getFileIds(k).size)
            // Make sure each list as a single element equal to fileId
            assertEquals(fileId, invertedIndex.getFileIds(k).first())
        }
    }
}
