package contests.qualification

fun main() {
    val (a, b, n) = readln().split(" ").map { it.toInt() }
    val gcd = gcd(a, b)
    if (n % gcd != 0) {
        println("NO")
        return
    }
}

fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    return gcd(b % a, a)
}