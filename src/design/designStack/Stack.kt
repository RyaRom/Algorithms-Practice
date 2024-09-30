package design.designStack

class CustomStack(maxSize: Int) {
    private val holder = IntArray(maxSize)
    private var top = -1

    fun push(x: Int) {
        if (top == holder.size - 1) return
        top++
        holder[top] = x
    }

    fun pop(): Int {
        if (top < 0) return -1
        top--
        return holder[top + 1]
    }

    fun increment(k: Int, `val`: Int) {
        for (i in 0..minOf(k - 1, top)) {
            holder[i] += `val`
        }
    }
}