package shshon.study.leet_code.medium

import kotlin.test.Test
import kotlin.test.assertEquals

class Count_and_SayTest {

    val sut = Count_and_Say()

    @Test
    fun test_case1() {
        val actual = sut.countAndSay(1)
        assertEquals(actual, "1")
    }

    @Test
    fun test_case2() {
        val actual = sut.countAndSay(4)
        assertEquals(actual, "1211")
    }
}
