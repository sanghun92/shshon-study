package shshon.study.leet_code.easy

import java.util.*

class Valid_Parentheses {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (bracket in s) {
            when(bracket) {
                '(' -> stack.push(')')
                '{' -> stack.push('}')
                '[' -> stack.push(']')
                else -> {
                    if(stack.isEmpty()) return false
                    if(stack.pop() != bracket) return false
                }
            }
        }

        return stack.isEmpty()
    }
}
