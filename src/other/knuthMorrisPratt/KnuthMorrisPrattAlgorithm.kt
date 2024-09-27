package other.knuthMorrisPratt

class KnuthMorrisPrattAlgorithm {
    companion object {
        fun findBiggestPalindromePrefix(str: String): Int {
            val combined = str + "#" + str.reversed()
            val chars = combined.toCharArray()
            val prefixTable = IntArray(chars.size)
            for (i in 1 until chars.size) {
                var len = prefixTable[i - 1]
                while (len > 0 && chars[i] != chars[len]) {
                    len = prefixTable[len - 1]
                }
                if (chars[i] == chars[len]) {
                    len++
                }
                prefixTable[i] = len
            }
            return prefixTable[combined.length - 1] - 1
        }
    }
}