package stack.removeStrOccurence

fun main() {
    println(Solution().minLength("ACdDB"))
}

class Solution {
    fun minLength(s: String): Int {
        val stack = mutableListOf<Char>()
        for (ch in s) {
            if (ch == 'D') {
                if (stack.lastOrNull() == 'C') {
                    stack.removeLast()
                } else {
                    stack.add(ch)
                }
            } else if (ch == 'B') {
                if (stack.lastOrNull() == 'A') {
                    stack.removeLast()
                } else {
                    stack.add(ch)
                }
            } else {
                stack.add(ch)
            }
        }

        return stack.size
    }
}