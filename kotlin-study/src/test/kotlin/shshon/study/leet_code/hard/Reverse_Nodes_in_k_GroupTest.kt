package shshon.study.leet_code.hard

import shshon.study.leet_code.createListNode
import kotlin.test.Test
import kotlin.test.assertEquals

class Reverse_Nodes_in_k_GroupTest {

    val sut = Reverse_Nodes_in_k_Group()

    @Test
    fun test() {
        val head = createListNode(listOf(1, 2, 3, 4, 5))

        val actual = sut.reverseKGroup(head = head, k = 2)

        assertEquals(actual, createListNode(listOf(2,1,4,3,5)))
    }

    @Test
    fun test2() {
        val head = createListNode(listOf(1, 2, 3, 4, 5))

        val actual = sut.reverseKGroup(head = head, k = 3)

        assertEquals(actual, createListNode(listOf(3,2,1,4,5)))
    }

    @Test
    fun test3() {
        val head = createListNode(listOf(1, 2))

        val actual = sut.reverseKGroup(head = head, k = 2)

        assertEquals(actual, createListNode(listOf(2,1)))
    }

    @Test
    fun test4() {
        val head = createListNode(listOf(1, 2, 3, 4))

        val actual = sut.reverseKGroup(head = head, k = 4)

        assertEquals(actual, createListNode(listOf(4, 3, 2, 1)))
    }
}
