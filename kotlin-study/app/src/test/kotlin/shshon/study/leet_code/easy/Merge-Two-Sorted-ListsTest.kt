package shshon.study.leet_code.easy

import kotlin.test.Test

class `Merge-Two-Sorted-ListsTest` {

    val sut = `Merge-Two-Sorted-Lists`()

    @Test
    fun mergeTwoListsTest() {
        val list1 = createListNode(list = listOf(1, 2, 4))
        val list2 = createListNode(list = listOf(1, 3, 4))

        val actual = sut.mergeTwoLists(
            list1 = list1,
            list2 = list2
        )
    }

    private fun createListNode(list: List<Int>) = list.map {
        ListNode(it)
    }.reduce { acc, listNode ->
        var last: ListNode = acc
        while (last.next != null) {
            last = last.next!!
        }
        last.next = listNode
        acc
    }
}
