package simulation.vectorToMatrix

class Solution {
    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        if (n * m != original.size) return arrayOf()
        val matrix = Array(m) { IntArray(n) }
        var k = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                matrix[i][j] = original[k]
                k++
            }
        }
        return matrix
    }
}