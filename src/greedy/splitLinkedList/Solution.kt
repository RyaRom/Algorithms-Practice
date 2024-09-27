package greedy.splitLinkedList

class ListNode(var `val`: Int) {
    var next: ListNode? = null

}

fun main() {
    val head = ListNode(0).apply {
        next = ListNode(1)

    }
    println(Solution().splitListToParts(head, 1))
}

class Solution {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        val arrayOfNodes = Array<ListNode?>(k) { null }
        val nodes: MutableList<ListNode> = mutableListOf()
        var current = head
        while (current != null) {
            nodes.add(current)
            current = current.next
        }
        var nodesForFirst = nodes.size % k
        val nodesForAll = nodes.size / k

        var i = 0
        var j = 0
        var arrayIndex = 0
        var previous = head
        for (node in nodes) {
            if (nodesForFirst > 0) {
                if (j % (nodesForAll + 1) == 0) {
                    if (node != head) previous?.next = null
                    arrayOfNodes[arrayIndex] = node
                    arrayIndex++
                    nodesForFirst--
                }
                j++
            } else {
                if (i % nodesForAll == 0 && (i != 0 || nodes.size % k == 0)) {
                    if (node != head) previous?.next = null
                    arrayOfNodes[arrayIndex] = node
                    arrayIndex++
                }
                i++
            }
            previous = node
        }
        return arrayOfNodes
    }
}