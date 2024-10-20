package stack.booleanParse

fun main() {
    println(Solution().parseBoolExpr("!(&(f,t))"))
}

class Solution {
    fun parseBoolExpr(expression: String): Boolean {
        val expr = ArrayList<String>()
        for (ch in expression) {
            when (ch) {
                ')' -> {
                    val sub = ArrayList<String>()
                    var current = expr.removeLast()
                    while (current != "(") {
                        sub.add(current)
                        current = expr.removeLast()
                    }
                    expr.add(processExpr(sub, expr.removeLast()))
                }

                ',' -> {}
                else -> expr.add(ch.toString())
            }
        }
        return expr.first() == "t"
    }

    private fun processExpr(expr: ArrayList<String>, operation: String): String {
        if (operation == "!") {
            return if (expr.first() == "t") "f" else "t"
        }
        if (operation == "|") {
            return if (expr.contains("t")) "t" else "f"
        }
        if (operation == "&") {
            return if (expr.contains("f")) "f" else "t"
        }
        throw IllegalStateException()
    }
}