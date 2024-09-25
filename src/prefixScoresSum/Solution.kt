package prefixScoresSum

class Solution {
    fun sumPrefixScores(words: Array<String>): IntArray {
        val prefixes = HashMap<String, Int>()
        return words.map { countAllPrefixes(words, prefixes, it) }.toIntArray()
    }

    private fun countAllPrefixes(words: Array<String>, prefixes: MutableMap<String, Int>, word: String): Int {
        var sum = 0
        for (i in 1..word.length) {
            val prefix = word.substring(0, i)
            if (prefix in prefixes.keys) {
                sum += prefixes[prefix]!!
            } else {
                val score = words.count { it.startsWith(prefix) }
                sum += score
                prefixes[prefix] = score
            }
        }
        return sum
    }
}

class SolutionTrie {
    fun sumPrefixScores(words: Array<String>): IntArray {
        val trie = Trie()
        words.forEach { trie.insert(it) }
        return words.map { trie.getScore(it) }.toIntArray()
    }

    private class TrieNode {
        val children = HashMap<Char, TrieNode>()
        var score = 0
    }

    private class Trie {
        val root = TrieNode()

        fun insert(word: String) {
            var node = root

            for (char in word) {
                val nodeChildren = node.children
                nodeChildren.putIfAbsent(char, TrieNode())
                nodeChildren[char]!!.score++
                node = nodeChildren[char]!!
            }
        }

        fun getScore(word: String): Int {
            var score = 0
            var node = root

            for (char in word) {
                val nodeChildren = node.children
                score += nodeChildren[char]!!.score
                node = nodeChildren[char]!!
            }

            return score
        }
    }
}