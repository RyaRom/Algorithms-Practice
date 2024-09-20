package shortestPalindrome

fun main() {
    println(Solution().shortestPalindrome(""))
}

class Solution {
    fun shortestPalindrome(s: String): String {
        if (s.isBlank()) return ""
        val nearestPalindromeEnd = findBiggestPalindrome(s)
        if (nearestPalindromeEnd == s.length - 1) return s
        val postfix = s.substring(nearestPalindromeEnd + 1).reversed()
        return postfix + s
    }

    private fun String.isPalindrome(): Boolean {
        var left = 0
        var right = this.length - 1
        while (left < right) {
            if (this[left] != this[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }

    private fun findBiggestPalindrome(str: String): Int {
        val chars = str.toCharArray()
        var max = 0
        for (i in chars.indices) {
            if (str.substring(0, i + 1).isPalindrome()) max = i
        }
        return max
    }
}