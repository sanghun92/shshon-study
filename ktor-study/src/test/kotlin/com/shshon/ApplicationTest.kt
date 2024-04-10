package com.shshon

import com.shshon.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }

    @Test
    fun testLeetCode() {
        threeSumClosest(intArrayOf(-1,2,1,-4), 2)
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        // -4, -1, 1, 2
        var answer = Int.MAX_VALUE
        for (i in 2 until nums.size) {
            val originClosetRate = abs(answer.coerceAtLeast(target) + answer.coerceAtMost(target))
            val sum = nums[i - 2] + nums[i - 1] + nums[i]
            val currentClosetRate = abs(sum.coerceAtLeast(target) + sum.coerceAtMost(target))

            if(originClosetRate > currentClosetRate) {
                answer = sum
            }
        }
        return answer
    }
}
