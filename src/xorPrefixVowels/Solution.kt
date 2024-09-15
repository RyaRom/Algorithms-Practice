package xorPrefixVowels

class Solution {
    fun findTheLongestSubstring(s: String): Int {
        var prefixXor = 0
        val characterMap = Array(26) { 0 }
        characterMap['a' - 'a'] = 1
        characterMap['e' - 'a'] = 2
        characterMap['i' - 'a'] = 4
        characterMap['o' - 'a'] = 8
        characterMap['u' - 'a'] = 16
        val mp = IntArray(32) { -1 }
        var max = 0

        val stArr = s.toCharArray();
        for (i in stArr.indices) {
            val ch = stArr[i]
            prefixXor = characterMap[ch - 'a'] xor prefixXor
            if (mp[prefixXor] == -1 && prefixXor != 0) mp[prefixXor] = i
            max = maxOf(max, i - mp[prefixXor])
        }
        return max
    }
}