package com.goose.index

import com.goose.file.FileId

class Index {

	private val index = HashMap<FileId, ArrayList<Pair<String, Long>>>()

	fun addFileIndex(fileId: FileId, fileIndex: Map<String, Long>) {
		val l = ArrayList(fileIndex.toList())
		l.sortByDescending { it.second }
		if (!index.contains(fileId)) {
			index.put(fileId, l)
		}
	}

	fun getWordCounts(fileId: FileId): ArrayList<Pair<String, Long>>? = index.get(fileId)

	fun containsFileId(fileId: FileId): Boolean = index.contains(fileId)
}
