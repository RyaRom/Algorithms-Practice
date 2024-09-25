package longestCommonPrefix

fun main() {
    println(Solution().longestCommonPrefix(arrayOf("flower", "flow", "flight")))
}

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val trie = Trie().also { it.insert(strs.first()) }
        strs.forEach { trie.insertWithPrefix(it) }
        if (trie.maxLength == 0) return ""
        return strs.first().substring(0, trie.maxLength - 1)
    }

    private class TrieNode {
        val children = HashMap<Char, TrieNode>()
    }

    private class Trie {
        val root = TrieNode()
        var maxLength = 0

        fun insert(word: String) {
            var current = root

            for (char in word) {
                val nodeChildren = current.children
                nodeChildren.putIfAbsent(char, TrieNode())
                current = nodeChildren[char]!!
            }
            maxLength = word.length
        }

        fun insertWithPrefix(word: String) {
            var current = root
            var len = 0

            for (char in word) {
                len++
                val nodeChildren = current.children
                if (!nodeChildren.containsKey(char)) {
                    break
                }
                current = nodeChildren[char]!!
            }
            maxLength = len
            current.children.clear()
        }
    }
}