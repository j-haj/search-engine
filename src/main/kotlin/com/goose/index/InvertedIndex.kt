package com.goose.index

import com.goose.file.FileId

class InvertedIndex {
    // Stores a mapping from word to FileId
    val invertedIndex = HashMap<String, ArrayList<FileId>>()

    /**
     * Adds a file index to the inverted index. Because the inverted index only
     * maps words to files, the word count is discarded.
     *
     * @param fileId: The FileId object for the respective file.
     * @param index: The index generated from `fileId`
     */
    fun addFileIndex(fileId: FileId, index: Map<String, Long>) {
        index.forEach {
            k, _ ->
                val l = invertedIndex.getOrElse(k) { arrayListOf(fileId) }
                l.add(fileId)
        }
    }

    /**
     * Returns a possibly null list of FileIds. The result is null when the word is
     * not found in the inverted index.
     *
     * @param word: The word being looked up in inverted index.
     * @return a possibly null list of FileIds
     */
    fun getFileIds(word: String): List<FileId>? = invertedIndex.get(word)

    /**
     * Checks if the given word is contained in the inverted index.
     *
     * @param word: the word being checked in the inverted index.
     * @return `true` if the word exists in the inverted index and `false` otherwise.
     */
    fun containsWord(word: String): Boolean = invertedIndex.contains(word)
}
