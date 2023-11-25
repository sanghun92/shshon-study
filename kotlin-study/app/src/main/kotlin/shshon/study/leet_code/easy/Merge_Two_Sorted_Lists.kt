package shshon.study.leet_code.easy

import shshon.study.leet_code.ListNode

class Merge_Two_Sorted_Lists {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 != null && list2 != null) {
            if (list1.`val` <list2.`val` ){
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            }
            else{
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null)
            return list2;
        return list1;
    }
}

// 1
// 1, 2, 4
// 1, 3, 4

// 2
// 1

//
