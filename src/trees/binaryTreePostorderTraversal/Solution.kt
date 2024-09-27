package trees.binaryTreePostorderTraversal

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val nodes = ArrayList<Int>()
        dfs(root, nodes)
        return nodes
    }

    private fun dfs(node: TreeNode?, nodes: MutableList<Int>) {
        if (node == null) return
        if (node.isLeaf()) {
            nodes.add(node.`val`)
            return
        }
        dfs(node.left, nodes)
        dfs(node.right, nodes)
        nodes.add(node.`val`)
    }

    private fun TreeNode.isLeaf(): Boolean = (this.left == null && this.right == null)
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}