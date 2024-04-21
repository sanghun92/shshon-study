package shshon.study.leet_code.medium

import kotlin.test.Test
import kotlin.test.assertEquals

class `3Sum_ClosestTest` {

    val sut = `3Sum_Closest`()

    @Test
    fun threeSumClosestTest() {
        // given
        val nums = intArrayOf(-1,2,1,-4)
        val target = 1

        // when
        val actual = sut.threeSumClosest(nums, target)

        // then
        assertEquals(actual, 2)
    }
}
