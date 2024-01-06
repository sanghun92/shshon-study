package shshon.study.leet_code.medium

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Valid_SudokuTest {

    val sut = Valid_Sudoku()

    @Test
    fun test_case1() {
        val input = arrayOf(
            charArrayOf('5','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9'),
        )
        val actual = sut.isValidSudoku(input)
        assertTrue(actual)
    }

    @Test
    fun test_case2() {
        val input = arrayOf(
            charArrayOf('8','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9'),
        )
        val actual = sut.isValidSudoku(input)
        assertFalse(actual)
    }

    

    @Test
    fun test_case3() {
        val input = arrayOf(
            charArrayOf('.', '.', '4', '.', '.', '.', '6', '3', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('5', '.', '.', '.', '.', '.', '.', '9', '.'),
            charArrayOf('.', '.', '.', '5', '6', '.', '.', '.', '.'),
            charArrayOf('4', '.', '3', '.', '.', '.', '.', '.', '1'),
            charArrayOf('.', '.', '.', '7', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '5', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
        )
        val actual = sut.isValidSudoku(input)
        assertFalse(actual)
    }
}
