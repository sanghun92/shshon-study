package shshon.study

import Solution
import org.junit.Test

class SolutionTest {

    @Test
    fun test() {
        val sut = Solution()
        val actual = sut.firstMissingPositive(
            intArrayOf(3, -1, 6, 2, 1)
        )
        print(actual)
    }
}
