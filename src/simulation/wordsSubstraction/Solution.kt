package simulation.wordsSubstraction

class Solution {
    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        val wordSet: MutableSet<String> = mutableSetOf()
        val uniqueWords: MutableSet<String> = mutableSetOf()
        for (word in s1.split(" ")) {
            if (wordSet.contains(word)) {
                uniqueWords.remove(word)
            } else {
                wordSet.add(word)
                uniqueWords.add(word)
            }
        }
        for (word in s2.split(" ")) {
            if (wordSet.contains(word)) {
                uniqueWords.remove(word)
            } else {
                wordSet.add(word)
                uniqueWords.add(word)
            }
        }
        return uniqueWords.toTypedArray()
    }
}