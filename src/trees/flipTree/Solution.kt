package trees.flipTree


data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)

    root1.left?.left = TreeNode(4)
    root1.left?.right = TreeNode(5)

    root1.right?.left = TreeNode(6)

    root1.left?.right?.left = TreeNode(7)
    root1.left?.right?.right = TreeNode(8)
    val root2 = TreeNode(1)
    root2.left = TreeNode(3)
    root2.right = TreeNode(2)

    root2.left?.right = TreeNode(6)
    root2.right?.left = TreeNode(4)
    root2.right?.right = TreeNode(5)

    root2.left?.right?.left = TreeNode(8)
    root2.right?.right?.right = TreeNode(7)

    println(Solution().flipEquiv(root1, root2))
}

class Solution {
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1 == null && root2 == null) return true
        if (root1 == null || root2 == null) return false
        val tree1 = HashMap<TreeNode, Set<TreeNode?>>()
        val tree2 = HashMap<TreeNode, Set<TreeNode?>>()
        mapTreeDfs(root1, tree1)
        mapTreeDfs(root2, tree2)
        for (node in tree1.keys) {
            if (node !in tree2.keys) return false
            if (tree1[node]!!.first() !in tree2[node]!!) return false
            if (tree1[node]!!.last() !in tree2[node]!!) return false
        }
        for (node in tree2.keys) {
            if (node !in tree1.keys) return false
        }
        return true
    }

    private fun mapTreeDfs(root: TreeNode?, map: MutableMap<TreeNode, Set<TreeNode?>>) {
        if (root == null) return
        map[root] = setOf(root.left, root.right)
        mapTreeDfs(root.left, map)
        mapTreeDfs(root.right, map)
    }
}