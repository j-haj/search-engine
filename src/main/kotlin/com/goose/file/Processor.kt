package com.goose.file

interface Processor {
    fun process(input: String): List<String>
}

class DefaultProcessor : Processor {
    override fun process(input: String): List<String>  = input
        .replace(Regex("""\p{Punct}"""), "")
        .split(Regex("""\s+"""))
        .filter {!it.isEmpty() }
        .map { it.toLowerCase() }
        .toList()


}
