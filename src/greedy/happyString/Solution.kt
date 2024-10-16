package greedy.happyString

import java.util.*

class Solution {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val heap: PriorityQueue<IntArray?> = PriorityQueue(Comparator.comparingInt<IntArray?> { it[0] }.reversed())
        heap.add(intArrayOf(a, 0))
        heap.add(intArrayOf(b, 1))
        heap.add(intArrayOf(c, 2))
        val res = StringBuilder()

        while (true) {
            val closest = heap.poll() ?: break
            if (closest[0] == 0) continue
            if (isInsertable(res, closest[1])) {
                closest[0]--
                if (closest[0] > 0) heap.add(closest)
            } else {
                val secondClosest = heap.poll() ?: break
                if (secondClosest[0] == 0) {
                    heap.add(closest)
                    continue
                }
                if (isInsertable(res, secondClosest[1])) {
                    secondClosest[0]--
                    heap.add(closest)
                    if (secondClosest[0] > 0) heap.add(secondClosest)
                } else {
                    heap.add(closest)
                    heap.add(secondClosest)
                    val thirdClosest = heap.poll() ?: break
                    if (thirdClosest[0] == 0) {
                        continue
                    }
                    if (isInsertable(res, thirdClosest[1])) {
                        thirdClosest[0]--
                        if (thirdClosest[0] > 0) heap.add(thirdClosest)
                    } else {
                        break
                    }
                }
            }
        }
        return res.toString()
    }

    private fun isInsertable(res: StringBuilder, type: Int): Boolean {
        val c = if (type == 0) 'a' else if (type == 1) 'b' else 'c'
        val n = res.length
        if (n < 2 || res[n - 2] != c || res[n - 1] != c) {
            res.append(c)
            return true
        } else return false
    }
}

fun main() {
    println(Solution().longestDiverseString(0, 1, 7))
}