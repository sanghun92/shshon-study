package shshon.study.leet_code.easy

import shshon.study.leet_code.createListNode
import kotlin.test.Test

class Merge_Two_Sorted_ListsTest {

    val sut = Merge_Two_Sorted_Lists()

    @Test
    fun mergeTwoListsTest() {
        val list1 = createListNode(list = listOf(1, 2, 4))
        val list2 = createListNode(list = listOf(1, 3, 4))

        val actual = sut.mergeTwoLists(
            list1 = list1,
            list2 = list2
        )
    }
}
