package linkedListGCD

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val head = ListNode(18).apply {
        next = ListNode(6).apply {
            next = ListNode(10).apply {
                next = ListNode(3).apply {}
            }
        }
    }
    println(Solution().insertGreatestCommonDivisors(head))
}

class Solution {
    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        var current = head
        while (current?.next != null) {
            val nextNode = current.next
            val gcdNode = ListNode(gcd(current.`val`, nextNode!!.`val`))
            current.next = gcdNode
            gcdNode.next = nextNode
            current = nextNode
        }
        return head
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }
}