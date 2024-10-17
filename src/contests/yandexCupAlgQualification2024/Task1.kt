package contests.yandexCupAlgQualification2024

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toLong() }
    val n = readln().toLong()
    if (a == b && b == c || (a == 1L && b == 1L) || (b == 1L && c == 1L) || (a == 1L && c == 1L)) {
        println(-1)
        return
    }
    val lcmAb = lcm(a, b)
    val lcmBc = lcm(b, c)
    val lcmAc = lcm(a, c)
    val lcmAbc = lcm(listOf(a, b, c))

    var min = 0L
    var max = 4090000000000000000
    var mid = 0L
    while (max > min) {
        mid = (max + min) / 2
        if (numsBeforeN(mid, lcmAb, lcmAc, lcmBc, lcmAbc) < n) {
            min = mid + 1
        } else {
            max = mid
        }
    }
    if ((min % a == 0L && min % b == 0L && min % c == 0L) || min < 0 || min > 1000000000000000000L) println(-1)
    else println(min)
}

fun gcd(a: Long, b: Long): Long {
    if (b == 0L) return a
    return gcd(b, a % b)
}

fun lcm(a: Long, b: Long): Long {
    return (a * b) / gcd(a, b)
}

fun lcm(list: List<Long>): Long {
    return list.reduce { acc, i -> lcm(acc, i) }
}

fun numsBeforeN(n: Long, lcmAb: Long, lcmBc: Long, lcmAc: Long, lcmAbc: Long): Long {
    val f = n / lcmAb
    val s = n / lcmAc
    val t = n / lcmBc
    return (f + s + t) - 3 * (n / lcmAbc)
}