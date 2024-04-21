package shshon.study.leet_code.medium

import kotlin.math.abs

class `3Sum_Closest` {

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var answer = Int.MAX_VALUE - target

        // -4, -1, 1, 2, 3, 4, 5
        for(i in 0 until nums.size - 2) {
            for(j in i + 1 until nums.size - 1) {
                for(k in j + 1 until nums.size) {
                    val sum = nums[i] + nums[j] + nums[k]
                    val sumRate = abs(sum - target)
                    val answerRate = abs(answer - target)
                    if(answerRate > sumRate) {
                        answer = sum
                    }
                }
            }
        }

        return answer
    }
}
