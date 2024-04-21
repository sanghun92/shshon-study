package shshon.study.leet_code

data class ListNode(var `val`: Int) {
    var next: ListNode? = null

    private fun print(): String {
        val output = StringBuilder("${this.`val`}")
        var next = this.next
        while(next != null) {
            output.append(" -> ${next.`val`}")
            next = next.next
        }
        return output.toString()
    }

    override fun toString(): String {
        return this.`val`.toString()
    }
}
