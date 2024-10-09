package greedy.kthLargest

import java.util.*

class KthLargest(private val k: Int, nums: IntArray) {
    private val container = PriorityQueue<Int>()

    init {
        for (n in nums) {
            add(n)
        }
    }

    fun add(n: Int): Int {
        if (container.size < k) {
            container.offer(n)
        } else if (container.peek() < n) {
            container.poll()
            container.offer(n)
        }
        return container.peek()
    }
}

fun main() {
    val kthLargest = KthLargest(4, intArrayOf(4, 5, 8, 2))
    println(kthLargest.add(3))  // Output: 4
    println(kthLargest.add(5))  // Output: 5
    println(kthLargest.add(10)) // Output: 5
    println(kthLargest.add(1))  // Output: 5
    println(kthLargest.add(8))  // Output: 8
}
