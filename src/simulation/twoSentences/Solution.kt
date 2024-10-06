package simulation.twoSentences

fun main() {
    println(Solution().areSentencesSimilar("A A AAa", "A AAa a"))
}

class Solution {
    fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
        if (sentence1 == sentence2) return true
        val sentence1Arr = sentence1.split(" ")
        val sentence2Arr = sentence2.split(" ")
        val max: List<String>;
        val min: List<String>;
        if (sentence1Arr.size > sentence2Arr.size) {
            max = sentence1Arr
            min = sentence2Arr
        } else {
            max = sentence2Arr
            min = sentence1Arr
        }

        var first = 0
        var last = 0
        if (min.size == 1 && (max.first() == min[0]||max.last() == min[0]) ) return true
        if (max.first() == min.first() && max.last() != min.last()) {
            while (last < min.size && max[last] == min[last]) last++
            return last == min.size
        } else if (max.first() != min.first() && max.last() == min.last()) {
            while (first < min.size && max[max.size - 1 - first] == min[min.size - 1 - first]) first++
            return first == min.size
        } else if (max.first() == min.first() && max.last() == min.last()) {
            while (first < min.size && max[first] == min[first]) first++
            while (last < min.size && max[max.size - 1 - last] == min[min.size - 1 - last]) last++
            return first + last >= min.size
        } else {
            return false
        }
    }
}