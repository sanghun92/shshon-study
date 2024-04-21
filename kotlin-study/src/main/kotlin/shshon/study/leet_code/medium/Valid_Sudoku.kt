package shshon.study.leet_code.medium

class Valid_Sudoku {

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // row 1-9값으로 유니크한지
        // col 1-9값으로 유니크한지
        // 3x3 block 1-9값으로 유니크한지

        val checker = hashSetOf<String>()
        for(i in 0 until 9) {
            for(j in 0 until 9) {
                val number = board[i][j]
                if('.' == number) {
                    continue
                }

                if(checker.add("R${i}:$number").not()) {
                    return false
                }

                if(checker.add("C${j}:$number").not()) {
                    return false
                }

                if(checker.add("B${i/3}-${j/3}:$number").not()) {
                    return false
                }
            }
        }
        return true
    }
}
