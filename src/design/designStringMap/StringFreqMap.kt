package design.designStringMap

fun main() {
    val map = AllOne()
    map.inc("a")
    map.inc("b")
    map.inc("b")
    map.inc("b")
    map.inc("b")
    map.dec("b")
    map.dec("b")
    println("Max key: " + map.getMaxKey())
    println("Min key: " + map.getMinKey())
}


class AllOne {
    class Node(var score: Int, val value: String) {
        var previous: Node? = null
        var next: Node? = null

        fun remove() {
            previous?.next = next
            next?.previous = previous
            next = null
            previous = null
        }

        private fun swap(node: Node?) {
            if (node == null || node == this) return

            val nextToNode = node.next
            val previousToNode = node.previous

            if (this.next == node) {
                this.next = nextToNode
                node.previous = previous

                if (nextToNode != null) {
                    nextToNode.previous = this
                }
                if (this.previous != null) {
                    this.previous?.next = node
                }

                node.next = this
                this.previous = node

            } else if (this.previous == node) {
                this.previous = previousToNode
                node.next = next

                if (previousToNode != null) {
                    previousToNode.next = this
                }
                if (this.next != null) {
                    this.next?.previous = node
                }

                node.previous = this
                this.next = node

            } else {
                this.previous?.next = node
                this.next?.previous = node

                nextToNode?.previous = this
                previousToNode?.next = this

                node.next = this.next
                node.previous = this.previous
                this.next = nextToNode
                this.previous = previousToNode
            }
        }


        fun inc() {
            score++
            if (next == null) return

            var current = next!!
            while (current.next != null && current.score < score) {
                current = current.next!!
            }
            if (current.score < score) this.swap(current)
            else if (current.previous?.score!! < score) this.swap(current.previous)
        }

        fun dec() {
            score--

            if (previous == null) return
            var current = previous!!
            while (current.previous != null && current.score > score) {
                current = current.previous!!
            }
            if (current.score > score) this.swap(current)
            else if (current.next?.score!! > score) this.swap(current.next)
        }
    }

    private val map = HashMap<String, Node>()
    private var max: Node? = null
    private var min: Node? = null

    fun inc(key: String) {
        if (max == null && min == null) {
            val firstInit = Node(1, key)
            map[key] = firstInit
            max = firstInit
            min = firstInit
            return
        }

        if (!map.containsKey(key)) {
            val newMin = Node(1, key)
            min!!.previous = newMin
            newMin.next = min
            min = newMin
            map[key] = newMin
            return
        }

        val node = map[key]!!
        node.inc()
        if (node.score > max!!.score) {
            max = node
        }

        if (min == node) {
            min = node.previous
            if (min == null) min = node
        }
    }

    fun dec(key: String) {
        val node = map[key] ?: return
        if (node.score == 1) {
            if (min == node) min = node.next
            if (max == node) max = node.previous
            node.remove()
            map.remove(key)
            return
        }

        node.dec()
        if (node.score < min!!.score) {
            min = node
        }

        if (max == node) {
            max = node.next
            if (max == null) max = node
        }
    }

    fun getMaxKey(): String = max?.value ?: ""

    fun getMinKey(): String = min?.value ?: ""
}