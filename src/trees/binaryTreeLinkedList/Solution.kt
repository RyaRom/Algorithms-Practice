package trees.binaryTreeLinkedList

internal class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

internal class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val head = ListNode(1).apply {
        next = ListNode(4).apply {
            next = ListNode(2).apply {
                next = ListNode(6)
            }
        }
    }

    val root = TreeNode(1).apply {
        left = TreeNode(4).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
            }
        }
        right = TreeNode(4).apply {
            left = TreeNode(2).apply {
                right = TreeNode(6).apply {
                    right = TreeNode(8).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                }
            }
        }
    }

    val result = Solution().isSubPath(head, root)
    println("Is subpath: $result")
}

class Solution {
    internal fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
        val toVisit = ArrayDeque<TreeNode?>()
        root?.let { toVisit.add(it) }
        var isSublistReal = false
        while (toVisit.isNotEmpty()) {
            val current = toVisit.removeFirstOrNull() ?: continue
            if (current.`val` == head?.`val`) {
                isSublistReal = isSublistReal || findSublist(current, head.next)
            }
            toVisit.add(current.left)
            toVisit.add(current.right)
        }
        return isSublistReal
    }

    private fun findSublist(root: TreeNode, head: ListNode?): Boolean {
        if (head == null) return true
        var isSublistReal = false
        if (root.left?.`val` == head.`val`) {
            isSublistReal = isSublistReal || findSublist(root.left!!, head.next)
        }
        if (root.right?.`val` == head.`val`) {
            isSublistReal = isSublistReal || findSublist(root.right!!, head.next)
        }
        return isSublistReal
    }
}