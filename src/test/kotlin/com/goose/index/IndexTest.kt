package com.goose.index

import com.goose.file.FileId

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class IndexTest {

    @Test
    fun testAddFileIndex() {
        val path = "/index/test/path/1"
        val fileId = FileId.issueFileId(path)
        val fileIndex = mapOf("a" to 1L, "b" to 2L, "c" to 3L, "d" to 4L)
        val index = Index()
        index.addFileIndex(fileId, fileIndex)
        assertTrue(index.containsFileId(fileId))
        assertTrue(index.getWordCounts(fileId) != null)
    }

    @Test
    fun testWordsAreSortedByFrequency() {
        val path = "/index/test/path/2"
        val fileId = FileId.issueFileId(path)
        val fileIndex = mapOf("a" to 1L, "b" to 2L, "c" to 3L, "d" to 4L)
        val index = Index()
        index.addFileIndex(fileId, fileIndex)
        val counts = index.getWordCounts(fileId)
        assertTrue(counts != null)
        if (counts != null) {
            for (i in 0 until counts.size - 1) {
                assertTrue(counts[i].first != counts[i+1].first)
                assertTrue(counts[i].second > counts[i+1].second)
            }
       }
    }
}
