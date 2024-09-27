package math.toBinary

fun main() {
    println(Solution().findComplement(1))
}

class Solution {
    fun findComplement(num: Int): Int {
        val sb = StringBuilder()
        var flag = false
        for (n in num.toString(2)) {
            if (n == '0') {
                flag = true
                sb.append('1')
            } else if (flag) {
                sb.append('0')
            }
        }
        if (sb.isEmpty()) return 0
        return sb.toString().toInt(2)
    }
}