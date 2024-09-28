package design.designCircularDeque

fun main() {
    val deque = MyCircularDeque(8)
    println(deque.insertFront(5))
    println(deque.deleteFront())
    println(deque.insertLast(3))
    println(deque.insertLast(7))
    println(deque.insertFront(3))
}

class MyCircularDeque(k: Int) {
    private val capacity = k
    private val values = IntArray(capacity) { -1 }
    private var head = 1
    private var bottom = 0

    private fun Int.addIndex(): Int = (this + 1) % capacity

    private fun Int.reduceIndex(): Int = (this - 1 + capacity) % capacity


    fun insertFront(value: Int): Boolean {
        if (isEmpty()) return insertLast(value)
        if (isFull()) return false
        values[head] = value
        head = head.addIndex()
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (isEmpty()) {
            values[bottom] = value
            head = bottom.addIndex()
            return true
        }
        if (isFull()) return false
        val newBottom = bottom.reduceIndex()
        values[newBottom] = value
        bottom = newBottom
        return true
    }

    fun deleteFront(): Boolean {
        if (isEmpty()) return false
        values[head.reduceIndex()] = -1
        head = head.reduceIndex()
        return true
    }

    fun deleteLast(): Boolean {
        if (isEmpty()) return false
        values[bottom] = -1
        bottom = bottom.addIndex()
        return true
    }

    fun getFront(): Int = if (isEmpty()) -1 else values[head.reduceIndex()]

    fun getRear(): Int = if (isEmpty()) -1 else values[bottom]

    fun isEmpty(): Boolean = values[bottom] == -1

    fun isFull(): Boolean = head == bottom && values[bottom] != -1

}