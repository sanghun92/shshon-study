package shshon.study.leet_code.medium

class Letter_Combinations_of_a_Phone_Number {

    private val answer = mutableListOf<String>()

    fun letterCombinations(digits: String): List<String> {
        dfs(0, digits, java.lang.StringBuilder())
        return answer
    }

    private fun dfs(depth: Int, digits: String, letters: StringBuilder) {
        if(letters.length == digits.length) {
            if(letters.toString() == "") {
                return
            }
            answer.add(letters.toString())
            return
        }

        // [0] : "a", "b", "c",
        // [1] : "d", "e", "f",
        // [2] : "g", "h", "i",
        for(letter in Letters.of(digits[depth])) {
            letters.append(letter)
            dfs(depth + 1, digits, letters)
            letters.setLength(letters.length - 1)
        }
    }
}

enum class Letters(val values: List<String>) {
    `2`(listOf("a", "b", "c")),
    `3`(listOf("d", "e", "f")),
    `4`(listOf("g", "h", "i")),
    `5`(listOf("j", "k", "l")),
    `6`(listOf("m", "n", "o")),
    `7`(listOf("p", "q", "r", "s")),
    `8`(listOf("t", "u", "v")),
    `9`(listOf("w", "x", "y", "z")),
    ;

    companion object {

        private val cache = values().associateBy { it.name }

        fun of(digit: Char): List<String> {
            return cache[digit.toString()]?.values
                ?: throw IllegalAccessException()
        }
    }
}
