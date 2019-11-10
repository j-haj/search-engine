package com.goose.query



data class Query(val query: String) {
    fun terms(): List<String> = query.toLowerCase()
        .replace(Regex("""\p{Punct}+"""), "")
        .split(Regex("""\s+"""))
        .filter { !it.isEmpty() }
        .toList()
}
