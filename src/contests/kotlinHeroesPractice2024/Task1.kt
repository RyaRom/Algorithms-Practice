package contests.kotlinHeroesPractice2024

fun main() {
    val n = readln().toInt();
    for (i in 1..n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        println("${minOf(a,b)} ${maxOf(a,b)}")
    }
}
