package shshon.study.leet_code.medium

import kotlin.test.Test

class Generate_ParenthesesTest {

    val sut = Generate_Parentheses()

    @Test
    fun generateParenthesisTest() {
        // given
        val n = 3

        // when
        val actual = sut.generateParenthesis(n = n)

        // then
        actual.containsAll(listOf(
            "((()))","(()())","(())()","()(())","()()()"
        ))
    }
}
