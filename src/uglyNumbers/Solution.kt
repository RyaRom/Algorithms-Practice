package uglyNumbers

import java.util.TreeSet

class Solution {
    fun nthUglyNumber(n: Int): Int {
        val dp = ArrayList<Long>()
        val toAdd = TreeSet<Long>()
        toAdd.add(1)
        while (!toAdd.isEmpty()){
            val small = toAdd.first()
            toAdd.add(small*2)
            toAdd.add(small*3)
            toAdd.add(small*5)
            dp.add(toAdd.pollFirst())
            if (dp.size == n)return dp.last().toInt()
        }
        return dp[n-1].toInt()
    }
}