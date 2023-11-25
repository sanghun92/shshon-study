package shshon.study.leet_code.medium

import shshon.study.leet_code.ListNode
import java.util.PriorityQueue

class Merge_k_Sorted_Lists {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val queue = PriorityQueue<Int>()
        lists.forEach { listNode ->
            listNode?.let {
                queue.offer(listNode.`val`)
                var next = listNode.next
                while(next != null) {
                    queue.offer(next.`val`)
                    next = next.next
                }
            }
        }

        if(queue.isEmpty()) {
            return null
        }
        val result = ListNode(queue.poll())
        var currentNode: ListNode = result

        while(queue.isNotEmpty()) {
            currentNode.next = ListNode(queue.poll())
            currentNode = currentNode.next!!
        }

        return result
    }
}
