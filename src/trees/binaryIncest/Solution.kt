package trees.binaryIncest


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val n1 = TreeNode(1)
    val n4 = TreeNode(4)
    val n5 = TreeNode(5)
    val n7 = TreeNode(7)
    val n9 = TreeNode(9)
    val n10 = TreeNode(10)
    n5.left = n4
    n5.right = n9
    n4.left = n1
    n4.right = n10
    n9.right = n7
    Solution().replaceValueInTree(n5)
}

class Solution {
    fun replaceValueInTree(root: TreeNode?): TreeNode? {
        val layers = HashMap<Int, Int>()
        mapNodes(root, 0, layers)
        setValues(root, 0, layers)
        root?.`val` = 0
        return root
    }


    private fun setValues(
        root: TreeNode?,
        layer: Int,
        layers: HashMap<Int, Int>,
    ) {
        if (root == null) return
        val left = root.left
        val right = root.right
        val childSum = (left?.`val` ?: 0) + (right?.`val` ?: 0)
        if (left != null) {
            left.`val` = (layers[layer] ?: 0) - childSum
        }
        if (right != null) {
            right.`val` = (layers[layer] ?: 0) - childSum
        }
        setValues(root.left, layer + 1, layers)
        setValues(root.right, layer + 1, layers)
    }

    private fun mapNodes(
        root: TreeNode?,
        layer: Int,
        layers: HashMap<Int, Int>,
    ) {
        if (root == null) return
        layers.putIfAbsent(layer, 0)
        var sum = 0
        if (root.left != null) {
            sum += root.left!!.`val`
        }
        if (root.right != null) {
            sum += root.right!!.`val`
        }
        layers[layer] = layers[layer]!! + sum
        mapNodes(root.left, layer + 1, layers)
        mapNodes(root.right, layer + 1, layers)
    }
}