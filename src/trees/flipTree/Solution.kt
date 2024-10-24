package trees.flipTree


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)
    val root2 = TreeNode(1)
    root2.left = TreeNode(3)
    root2.right = TreeNode(2)


    println(Solution().flipEquiv(root1, root2))
}

class Solution {
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1 == null && root2 == null) return true
        if (root1 == null || root2 == null) return false
        val tree1 = HashMap<Int, Set<Int>>()
        val tree2 = HashMap<Int, Set<Int>>()
        mapTreeDfs(root1, tree1)
        mapTreeDfs(root2, tree2)
        if (tree1.size != tree2.size) return false
        for (node in tree1.keys) {
            if (node !in tree2.keys) return false
            if (tree1[node]!!.first() !in tree2[node]!!) return false
            if (tree1[node]!!.last() !in tree2[node]!!) return false
        }
        return true
    }

    private fun mapTreeDfs(root: TreeNode?, map: MutableMap<Int, Set<Int>>) {
        if (root == null) return
        map[root.`val`] = setOf(root.left?.`val` ?: -100, root.right?.`val` ?: -100)
        mapTreeDfs(root.left, map)
        mapTreeDfs(root.right, map)
    }
}