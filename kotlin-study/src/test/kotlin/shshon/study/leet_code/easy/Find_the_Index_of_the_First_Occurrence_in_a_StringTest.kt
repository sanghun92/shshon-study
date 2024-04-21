package shshon.study.leet_code.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class Find_the_Index_of_the_First_Occurrence_in_a_StringTest {
    val sut = Find_the_Index_of_the_First_Occurrence_in_a_String()

    @Test
    fun test() {
        val actual = sut.strStr("sadbutsad", "sad")
        assertEquals(0, actual)
    }

    @Test
    fun test2() {
        val actual = sut.strStr("leetcode", "leeto")
        assertEquals(-1, actual)
    }
}
