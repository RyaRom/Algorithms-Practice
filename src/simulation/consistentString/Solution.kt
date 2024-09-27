package simulation.consistentString

class Solution {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        var sum = 0
        for (word in words) {
            var check = 1
            for (c in word.toCharArray()) {
                if (!allowed.contains(c)) check = 0
            }
            sum += check
        }
        return sum
    }
}