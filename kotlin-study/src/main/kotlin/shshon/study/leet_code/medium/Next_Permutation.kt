package shshon.study.leet_code.medium

class Next_Permutation {

    private var visited: BooleanArray = booleanArrayOf()
    private var comp = ""
    private var found = false

    fun nextPermutation(nums: IntArray): Unit {
        this.visited = BooleanArray(nums.size) { false }
        this.comp = nums.joinToString(separator = "")
        this.nextPermutationInternal(nums, 0, StringBuilder())
    }

    private fun nextPermutationInternal(nums: IntArray, depth: Int, values: StringBuilder): String {
        if(nums.size == depth) {
            return values.toString()
        }

        for(i in nums.indices) {
            if(visited[i]) {
                continue
            }

            visited[i] = true
            values.append(nums[i])
            if(found) {
                return values.toString()
            }

            val result = this.nextPermutationInternal(nums, depth + 1, values)

            values.setLength(values.length - 1)
            visited[i] = false
        }

        return ""
    }
}
