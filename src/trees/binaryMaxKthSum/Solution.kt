package trees.binaryMaxKthSum

import java.util.*

fun main() {
    val root = TreeNode(1).also { it.left = TreeNode(2).also { it1 -> it1.left = TreeNode(3) } }
    println(Solution().kthLargestLevelSum(root, 1))
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        if (root == null) return -1
        val sums = PriorityQueue<Long>(Comparator.reverseOrder())
        val toVisit = ArrayList<TreeNode>()
        toVisit.add(root)
        while (toVisit.isNotEmpty()) {
            var sum = 0L
            val toAdd = ArrayList<TreeNode>()
            while (toVisit.isNotEmpty()) {
                val current = toVisit.removeLast()
                sum += current.`val`
                if (current.left != null) toAdd.add(current.left!!)
                if (current.right != null) toAdd.add(current.right!!)
            }
            sums.add(sum)
            toVisit.addAll(toAdd)
        }
        if (k > sums.size) return -1
        for (i in 1 until k) {
            sums.remove()
        }
        return sums.remove()
    }
}