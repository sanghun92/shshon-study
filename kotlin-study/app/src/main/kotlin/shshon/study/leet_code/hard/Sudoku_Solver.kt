package shshon.study.leet_code.hard

class Sudoku_Solver {

    private val modifiable: Array<BooleanArray> = Array(9) {
        BooleanArray(9) { false }
    }
    private val result:Array<IntArray> = Array(9) {
        IntArray(9) { 0 }
    }

    fun solveSudoku(board: Array<CharArray>): Unit {
        this.makeModifiable(board)
        this.recurse(0)
        for(i in 0 until 9) {
            for(j in 0 until 9) {
                board[i][j] = this.result[i][j].toString().toCharArray()[0]
            }
        }
    }

    private fun makeModifiable(board: Array<CharArray>) {
        board.forEachIndexed { i, values ->
            values.forEachIndexed { j, value ->
                if('.' == value) {
                    this.modifiable[i][j] = true
                    this.result[i][j] = 0
                } else {
                    this.result[i][j] = value.digitToInt()
                }
            }
        }
    }

    private fun recurse(index: Int): Boolean {
        if(index == 81) {
            return true
        }

        val row = index / 9
        val column = index % 9

        for(candidate in 1 .. 9) {
            if(this.modifiable[row][column].not()) {
                return recurse(index + 1)
            }
            this.result[row][column] = candidate
            if(isValid(row, column) && recurse(index + 1)) {
                return true
            }
        }
        result[row][column] = 0
        return false
    }

    private fun isValid(row: Int, column: Int): Boolean {
        return isValidRow(column) && isValidColumn(row) && isValidBlock(row, column)
    }

    private fun isValidRow(column: Int): Boolean {
        val checker = hashSetOf<Int>()
        for(i in 0 until 9) {
            val value = this.result[i][column]
            if(value == 0) {
                continue
            }
            if(checker.add(value).not()) {
                return false
            }
        }
        return true
    }

    private fun isValidColumn(row: Int): Boolean {
        val checker = hashSetOf<Int>()
        for(i in 0 until 9) {
            val value = this.result[row][i]
            if(value == 0) {
                continue
            }
            if(checker.add(value).not()) {
                return false
            }
        }
        return true
    }

    private fun isValidBlock(row: Int, column: Int): Boolean {
        val checker = hashSetOf<Int>()
        for(i in (row / 3) * 3 until (row / 3) * 3 + 3) {
            for(j in (column / 3) * 3 until (column / 3) * 3 + 3) {
                val value = this.result[i][j]
                if(value == 0) {
                    continue
                }
                if(checker.add(value).not()) {
                    return false
                }
            }
        }
        return true
    }
}
