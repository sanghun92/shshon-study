package shshon.study.leet_code.medium

import shshon.study.leet_code.createListNode
import kotlin.test.Test
import kotlin.test.assertEquals

class Swap_Nodes_in_PairsTest {

    val sut = Swap_Nodes_in_Pairs()

    @Test
    fun test() {
        val node = createListNode(listOf(1, 2, 3, 4))

        val actual = sut.swapPairs(head = node)

        assertEquals(actual, createListNode(listOf(2, 1, 4, 3)))
    }
}
