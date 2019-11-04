package com.goose.file

import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.FileSystems


class Loader(val processor: Processor, val charset: Charset = StandardCharsets.UTF_8) {

	fun loadFile(path: String): Map<String, Int> {
		val m = HashMap<String, Int>()
		File(path).inputStream().bufferedReader().lines().forEach {
			processor
				.process(it)
				.forEach { t: String ->
			       m.put(t, (m.get(t) ?: 0) + 1)
				}
		}

		return m
	}
}
