package trees.nthTreePostorderTraversal

fun main() {
    val n1 = Node(1)
    val n2 = Node(2)
    val n3 = Node(3)
    val n4 = Node(4)
    val n5 = Node(5)
    val n6 = Node(6)
    val n7 = Node(7)
    val n8 = Node(8)
    val n9 = Node(9)
    val n10 = Node(10)
    val n11 = Node(11)
    val n12 = Node(12)
    val n13 = Node(13)
    val n14 = Node(14)
    n1.children = listOf(n2, n3, n4, n5)
    n5.children = listOf(n9, n10)
    n3.children = listOf(n6, n7)
    n7.children = listOf(n11)
    n11.children = listOf(n14)
    n4.children = listOf(n8)
    n8.children = listOf(n12)
    n9.children = listOf(n13)
    println(Solution().postorder(n1))
}

class Solution {

    fun postorder(root: Node?): List<Int> {
        val nodes: MutableList<Int> = mutableListOf()
        dfs(root, nodes)
        return nodes
    }

    private fun dfs(node: Node?, nodes: MutableList<Int>) {
        if (node == null) return
        if (node.children.isEmpty()) {
            nodes.add(node.`val`)
            return
        }
        node.children.forEach() { dfs(it, nodes) }
        nodes.add(node.`val`)
    }
}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}