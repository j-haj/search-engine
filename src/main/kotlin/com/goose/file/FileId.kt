package com.goose.file

data class FileId private constructor(val path: String, val id: Long) {
    companion object {
        // Used to generate unique IDs for each FileId issued
        private var nextId = 0L
        private var idLookup = HashMap<String, Long>()

        fun issueFileId(path: String): FileId {
            val i = nextId
            idLookup.put(path, i)
            nextId++
            return FileId(path, i)
        }

        /**
         * Retrieve a previously issued FileId for a given path.
         *
         * @param path the path corresponding to the previously issued FileId
         * @return The FileId if it exists or null.
         */
        fun lookupFileIdForPath(path: String): FileId? {
            val i = idLookup.get(path)
            if (i != null) return FileId(path, i)
            return null
        }
    }
}
