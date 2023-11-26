package shshon.study.leet_code.medium

import shshon.study.leet_code.ListNode

class Swap_Nodes_in_Pairs {

    fun swapPairs(head: ListNode?): ListNode? {
        var cnt = 1
        val dummyHead = ListNode(-1)
        dummyHead.next = head

        var previousPointer: ListNode? = dummyHead
        var pointer = dummyHead.next
        var nextPointer = pointer?.next

        while (nextPointer != null) {
            if(cnt++ % 2 == 1) {
                // -1(P) -> 2(N)
                // 1(C) -> 3(NN)
                // 2(N) -> 1(C)
                previousPointer?.next = nextPointer
                pointer?.next = nextPointer.next
                nextPointer.next = pointer

                previousPointer = previousPointer?.next
                pointer = nextPointer.next
                nextPointer = pointer?.next
            } else {
                previousPointer = previousPointer?.next
                pointer = pointer?.next
                nextPointer = nextPointer.next
            }
        }

        return dummyHead.next
    }
}
