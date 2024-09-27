package prefixSum.xorPrefixSum

class Solution {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val prefixXor = IntArray(arr.size + 1);
        for (i in arr.indices) {
            prefixXor[i + 1] = prefixXor[i] xor arr[i];
        }
        return queries.map { query ->
            prefixXor[query[1] + 1] xor prefixXor[query[0]]
        }.toIntArray();
    }
}