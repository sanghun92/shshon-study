package shshon.study

class Test {

    fun rotate(nums: IntArray, k: Int): Unit {
        val size = k % nums.size
        val nums2: IntArray = IntArray(nums.size - size)
        val nums3: IntArray = IntArray(size)
        for (i in 0 until nums2.size) {
            nums2[i] = nums[i]
        }

        for (i in 0 until nums3.size) {
            nums3[i] = nums[nums.size - size + i]
        }

        var j = 0
        for (i in 0 until nums3.size) {
            nums[j++] = nums3[i]
        }

        for (i in 0 until nums2.size) {
            nums[j++] = nums2[i]
        }
    }
}

fun main() {
    println(Test().rotate(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3))
}
