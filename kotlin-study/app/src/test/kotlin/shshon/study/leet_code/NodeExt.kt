package shshon.study.leet_code

fun createListNode(list: List<Int>): ListNode? {
    if(list.isEmpty()) {
        return null
    }

    return list.map {
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
