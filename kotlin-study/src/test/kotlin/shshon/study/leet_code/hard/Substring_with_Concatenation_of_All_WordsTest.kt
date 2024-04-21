package shshon.study.leet_code.hard

import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class Substring_with_Concatenation_of_All_WordsTest {

    val sut = Substring_with_Concatenation_of_All_Words()

    @Test
    fun test() {
        val actual = sut.findSubstring("barfoothefoobarman", arrayOf("foo", "bar"))
        listOf(0,9).forEach {
            assertContains(actual, it)
        }
    }

    @Test
    fun test2() {
        val actual = sut.findSubstring("wordgoodgoodgoodbestword", arrayOf("word","good","best","word"))
        assertEquals(0, actual.size)
    }

    @Test
    fun test3() {
        val actual = sut.findSubstring("barfoofoobarthefoobarman", arrayOf("bar","foo","the"))
        listOf(6, 9, 12).forEach {
            assertContains(actual, it)
        }
    }
}
