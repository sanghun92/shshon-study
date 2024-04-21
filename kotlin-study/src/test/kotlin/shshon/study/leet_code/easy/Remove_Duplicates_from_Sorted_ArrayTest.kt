package shshon.study.leet_code.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class Remove_Duplicates_from_Sorted_ArrayTest {

    val sut = Remove_Duplicates_from_Sorted_Array()

    @Test
    fun test() {
        val actual = sut.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4))

        assertEquals(5, actual)
    }

    @Test
    fun test2() {
        val actual = sut.removeDuplicates(intArrayOf(1,1,2))

        assertEquals(2, actual)
    }
}
