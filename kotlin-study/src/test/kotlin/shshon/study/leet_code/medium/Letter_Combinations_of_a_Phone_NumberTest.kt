package shshon.study.leet_code.medium

import org.junit.Test
import kotlin.test.assertEquals

class Letter_Combinations_of_a_Phone_NumberTest {

    val sut = Letter_Combinations_of_a_Phone_Number()

    @Test
    fun letterCombinationsTest() {
        // given
        val digits = "23"

        // when
        val actual = sut.letterCombinations(digits)

        // then
        assertEquals(actual, listOf("ad","ae","af","bd","be","bf","cd","ce","cf"))
    }
    @Test
    fun letterCombinationsTest2() {
        // given
        val digits = ""

        // when
        val actual = sut.letterCombinations(digits)

        // then
        assertEquals(actual, listOf())
    }
}
