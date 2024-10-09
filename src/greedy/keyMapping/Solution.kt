package greedy.keyMapping

fun main() {
    println(Solution().minimumPushes("alporfmdqsbhncwyu"))
}

class Solution {
    fun minimumPushes(word: String): Int {
        val freq = mutableMapOf<Char, Int>()
        for (c in word) {
            freq[c] = (freq[c] ?: 0) + 1
        }

        val sorted = freq.toList().sortedByDescending { it.second }
        var count = 0
        var i = 0
        var currentVal = 1

        for ((key, _) in sorted) {
            if (i < 8) {
                freq[key] = currentVal
                i++
            } else {
                currentVal++
                freq[key] = currentVal
                i = 1
            }
        }

        for (c in word) {
            count += freq[c] ?: 0
        }

        return count
    }
}
