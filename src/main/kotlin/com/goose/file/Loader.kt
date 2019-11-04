package com.goose.file

import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.FileSystems


class Loader(val processor: Processor, val charset: Charset = StandardCharsets.UTF_8) {

    fun loadFile(file: File): Map<String, Int> {
        val m = HashMap<String, Int>()
        file.inputStream().bufferedReader().lines().forEach {
            processor
                .process(it)
                .forEach { t -> m.put(t, (m.get(t) ?: 0) + 1) }
        }
        return m
    }
}
