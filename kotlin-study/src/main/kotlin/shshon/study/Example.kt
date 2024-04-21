class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        var i = 0
        /// for sorting using cyclic sort
        /// for sorting using cyclic sort
        while (i < nums.size) {
            if (nums[i] > 0 && nums[i] < nums.size && nums[i] !== nums[nums[i] - 1]) // it is good to make a separate function for swapping
            {
                val temp = nums[i]
                nums[i] = nums[nums[i] - 1]
                nums[temp - 1] = temp
            } else {
                i++
            }
        }

        // finding missing positive number
        // it means nums[0]=1,nums[1]=2, ....

        // finding missing positive number
        // it means nums[0]=1,nums[1]=2, ....
        for (j in 0 until nums.size) {
            if (nums[j] !== j + 1) {
                return j + 1
            }
        }
        return nums.size + 1
    }
}
