package shshon.study.leet_code.medium

class Permutations {
    private val result = mutableListOf<List<Int>>()
    private lateinit var check: BooleanArray

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        check = BooleanArray(nums.size) { false }
        nums.sort()

        dfs(nums, mutableListOf())
        return result
    }

    private fun dfs(nums: IntArray, values: MutableList<Int>) {
        if (nums.size == values.size) {
            result.add(values.toList())
            return
        }

        for (i in 0..nums.lastIndex) {
            if (check[i]) continue
            if (i > 0 && nums[i - 1] == nums[i] && check[i - 1]) continue

            check[i] = true
            values.add(nums[i])
            dfs(nums, values)

            check[i] = false
            values.removeLast()
        }
    }
}

fun main() {
    Permutations().permuteUnique(intArrayOf(1, 1, 2))
}
