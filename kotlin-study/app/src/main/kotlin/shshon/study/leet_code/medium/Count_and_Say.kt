package shshon.study.leet_code.medium

class Count_and_Say {
    fun countAndSay(n: Int): String {
        var result = "1"
        for (i in 2..n) {
            result = this.convert(result)
        }
        return result
    }

    private fun convert(value: String): String {
        val valueBuffer = StringBuilder()

        // 3322251
        var matchCount = 1
        val toCharArray = value.toCharArray()
        for(i in 0 until toCharArray.size) {
            if(i < toCharArray.size - 1 && toCharArray[i] == toCharArray[i + 1]) {
                matchCount++
                continue
            }
            valueBuffer.append("${matchCount}${toCharArray[i]}")
            matchCount = 1
        }
        return valueBuffer.toString()
    }
}
