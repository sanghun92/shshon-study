package shshon.study.leet_code.easy

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Valid_ParenthesesTest {

    private val sut = Valid_Parentheses()

    @Test
    fun validParenthesesTest() {
        val actual = sut.isValid("()[]{}")

        assertTrue(actual)
    }

    @Test
    fun validParenthesesTest2() {
        val actual = sut.isValid("(]")

        assertFalse(actual)
    }

    @Test
    fun validParenthesesTest3() {
        val actual = sut.isValid("]")

        assertFalse(actual)
    }
}
