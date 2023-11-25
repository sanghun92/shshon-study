package shshon.study.leet_code.medium

class Generate_Parentheses {

    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        this.backTracking(
            result = result,
            maxCount = n,
        )
        return result
    }

    /**
     * Termination condition : '('와 ')'의 개수가 n 인경우 종료
     * recurse :
     *   - '('의 개수가 n보다 작을 때 '(' 추가
     *   - ')'의 개수가 '('의 개수 보다 작을때 ')' 추가
     */
    private fun backTracking(
        result: MutableList<String>,
        maxCount: Int,
        row: String = "",
        frontCount: Int = 0,
        backCount: Int = 0,
    ) {
        // termination
        if(maxCount == frontCount && maxCount == backCount) {
            result.add(row)
            return
        }

        // '(' 추가
        if(frontCount < maxCount) {
            this.backTracking(
                result = result,
                maxCount = maxCount,
                row = "$row(",
                frontCount = frontCount + 1,
                backCount = backCount,
            )
        }

        // ')' 추가
        if(frontCount > backCount) {
            this.backTracking(
                result = result,
                maxCount = maxCount,
                row = "$row)",
                frontCount = frontCount,
                backCount = backCount + 1,
            )
        }
    }
}
