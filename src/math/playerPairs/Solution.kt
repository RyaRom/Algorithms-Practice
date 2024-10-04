package math.playerPairs

class Solution {
    fun dividePlayers(skill: IntArray): Long {
        val skillSorted = skill.sorted()
        val sum = skillSorted[0] + skillSorted[skillSorted.size - 1]
        var result = skillSorted[0].toLong() * skillSorted[skillSorted.size - 1]
        for (i in 1..skill.size / 2 - 1) {
            val newSum = skillSorted[i] + skillSorted[skillSorted.size - 1 - i]
            if (newSum != sum) {
                return -1
            }
            result += skillSorted[i] * skillSorted[skillSorted.size - 1 - i]
        }
        return result
    }
}