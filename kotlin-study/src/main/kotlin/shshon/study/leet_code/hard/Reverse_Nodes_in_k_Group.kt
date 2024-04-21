package shshon.study.leet_code.hard

import shshon.study.leet_code.ListNode
import java.util.Stack

class Reverse_Nodes_in_k_Group {

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummyHead = ListNode(0)
        dummyHead.next = head

        val stack = Stack<ListNode>()
        var groupPrev: ListNode? = dummyHead

        while (groupPrev != null) {
            changeStack(k, stack, groupPrev)
            if(stack.size < k) {
                return dummyHead.next
            }
            val groupNext = stack.peek().next
            groupPrev = popStack(stack, groupPrev, groupNext)
        }

        return dummyHead.next
    }

    private fun changeStack(
        k: Int,
        stack: Stack<ListNode>,
        pointer: ListNode?
    ) {
        var pointer1 = pointer?.next
        for (i in 0 until k) {
            if(pointer1 == null) {
                return
            }
            stack.push(pointer1)
            pointer1 = pointer1.next
        }
    }

    private fun popStack(stack: Stack<ListNode>, groupPrev: ListNode, groupNext: ListNode?): ListNode? {
        // 0 -> 1 -> 2 -> 3
        // 0 -> 3 -> 2 -> 1
        var firstOfGroup: ListNode? = null
        var lastOfGroup: ListNode? = null
        var prev: ListNode? = groupPrev
        var next: ListNode?

        while (stack.isNotEmpty()) {
            val current = stack.pop() // 2

            if(firstOfGroup == null) {
                firstOfGroup = current
            }

            if(stack.isEmpty()) {
                lastOfGroup = current
            }

            if(stack.isNotEmpty()) {
                next = stack.peek()
                prev?.next = current
                current.next = next
            }
            prev = current
        }

        groupPrev.next = firstOfGroup
        lastOfGroup?.next = groupNext

        return lastOfGroup
    }
}
