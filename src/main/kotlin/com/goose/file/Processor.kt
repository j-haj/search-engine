package com.goose.file

interface Processor {
	fun process(input: String): List<String>
}

class DefaultProcessor : Processor {
	override fun process(input: String): List<String>  = input
		.replace(Regex("""\p{Punct}"""), "")
		.split(Regex("""\s+"""))
		.filter { w -> !w.isEmpty() }
		.map { w -> w.toLowerCase() }
		.toList()


}
