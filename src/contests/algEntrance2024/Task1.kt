package contests.algEntrance2024

fun countValidPairs(n: Long, m: Long): Long {
    var count = 0L
    for (b in 1..m) {
        var a = b
        while (a <= n) {
            val g = gcd(a, b)
            var magic = b * g
            if (magic == 0L) magic = 1
            if ((a + b) % (magic) == 0L) {
                count++
            }
            a += b
        }
    }
    return count
}

tailrec fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) a else gcd(b, a % b)
}

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toLong() }
        println(countValidPairs(n, m))
    }
}
