package shshon.study.leet_code.easy

class Remove_Duplicates_from_Sorted_Array {

    fun removeDuplicates(nums: IntArray): Int {
        // 1,1,2
        var pointer = 1

        for(i in 1 until nums.size) {
            if(nums[i] != nums[pointer - 1]) {
                nums[pointer] = nums[i]
                pointer++
            }
        }

        return pointer
    }
}
