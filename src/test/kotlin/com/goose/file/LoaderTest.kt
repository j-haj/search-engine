package com.goose.file

import java.io.FileWriter

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.rules.TemporaryFolder
import org.junit.Rule
import org.junit.Test

class LoaderTest {

	@Rule @JvmField
	public val testFolder = TemporaryFolder()

	@Test
	fun testLoadFile() {
		testFolder.create()
		val fileName = "test.txt"
		val tempFile = testFolder.newFile(fileName)
		val content = "This is a Test; This will - be parsed! Don't and won't?"
		tempFile.writeText(content)

		val loader = Loader(DefaultProcessor())
		val got = loader.loadFile(tempFile)
		val expected = mapOf("this" to 2,
					   "is" to 1,
					   "a" to 1,
					   "test" to 1,
					   "will" to 1,
					   "be" to 1,
					   "parsed" to 1,
					   "dont" to 1,
					   "and" to 1,
					   "wont" to 1)
		assertEquals("frequencies are different", expected, got)
	}
}
