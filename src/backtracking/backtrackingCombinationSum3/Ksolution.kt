package BacktrackingCombinationSum3

class Ksolution {
    private var combinations = ArrayList<List<Int>>()
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        backtracking(0, n, k, ArrayList())
        return combinations
    }

    private fun backtracking(n: Int, sum: Int, k: Int, current: ArrayList<Int>) {
        if (sum == 0 && current.size == k) {
            combinations.add(ArrayList(current))
            return
        }
        if (sum < 0 || current.size >= k) return
        for (i in (n + 1)..minOf(sum, 9)) {
            val comb = ArrayList(current)
            comb.add(i)
            backtracking(i, sum - i, k, comb)
        }
    }
}