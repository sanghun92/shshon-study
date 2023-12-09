package shshon.study.leet_code.hard

class Substring_with_Concatenation_of_All_Words {

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val wordSize = words.first().length
        val totalSize = words.size * wordSize
        if(s.length < totalSize) {
            return emptyList()
        }

        // barfoothefoobarman
        // ["foo","bar"]
        // totalSize : 6

        // wordgoodgoodgoodbestword
        // "word","good","best","word"
        // totalSize : 16
        // wordgoodgoodgood

        val answer = mutableListOf<Int>()
        val wordCache = mutableMapOf<String, Int>()
        words.forEach {
            val value = wordCache.getOrDefault(it, 0) + 1
            wordCache[it] = value
        }

        for(i in 0 .. s.length - totalSize) {
            var count = 0
            val wordCountCache = mutableMapOf<String, Int>()
            for(j in i until totalSize + i step wordSize) {
                val currentWord = s.substring(j, j + wordSize)
                if (wordCache.contains(currentWord).not()) {
                    break
                }

                val value = wordCountCache.getOrDefault(currentWord, 0) + 1
                wordCountCache[currentWord] = value

                if(value <= wordCache[currentWord]!!) {
                    count++
                }
            }

            if(count == words.size) {
                answer.add(i)
            }
        }
        return answer
    }
}
