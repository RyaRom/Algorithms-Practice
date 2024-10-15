package contests.qualification

fun main() {
    readln()
    val arr = readln().split(" ").map { it.toInt() }
    val k = readln().toInt()
    var max = 0L
    var current = 0L

    for (i in arr.indices) {
        if (i < k) {
            current += arr[i]
            max = maxOf(max, current)
            continue
        }

        current += arr[i]
        current -= arr[i - k]
        max = maxOf(max, current)
    }
    println(max)
}