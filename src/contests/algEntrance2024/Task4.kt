package contests.algEntrance2024

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        solve(n)
    }
}

fun solve(n: Int) {
    var a = 0
    for (i in 1..n) {
        a += (2 * i - 1) * i
    }
    println("$a ${2 * n}")

    for (i in n downTo 1) {
        print("1 $i ")
        for (j in 1..n) {
            print("$j ")
        }
        println()
        print("2 $i ")
        for (j in 1..n) {
            print("$j ")
        }
        println()
    }
}