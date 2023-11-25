package shshon.study.leet_code.medium

import org.junit.Test
import shshon.study.leet_code.ListNode
import shshon.study.leet_code.createListNode
import kotlin.test.assertEquals

class Merge_k_Sorted_ListsTest {

    val sut = Merge_k_Sorted_Lists()

    @Test
    fun mergeKListsTest() {
        val lists = arrayOf(
            createListNode(listOf(1, 4, 5)),
            createListNode(listOf(1, 3, 4)),
            createListNode(listOf(2, 6)),
        )

        val actual = sut.mergeKLists(lists = lists)

        assertEquals(actual, createListNode(listOf(1, 1, 2, 3, 4, 4, 5, 6)))
    }
    @Test
    fun mergeKListsTest2() {
        val lists = arrayOf(
            createListNode(listOf()),
            createListNode(listOf(1)),
        )

        val actual = sut.mergeKLists(lists = lists)

        assertEquals(actual, createListNode(listOf(1)))
    }
}
