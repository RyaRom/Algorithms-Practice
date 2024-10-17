package contests.yandexCupAlgQualification2024

fun main() {
    var current = 1L
    var previous = 1L
    var mid = 0L
    while (true) {
        previous = current
        current *= 2
        println(current)
        System.out.flush()
        val response = readln()
        if (response == "wet") {
            continue
        }
        if (response == "ok") {
            val n = binarySearch(previous, current)
            println("! $n")
            break
        } else {
            break
        }
    }
}

fun binarySearch(left: Long, right: Long): Long {
    var l = left
    var r = right
    while (l < r) {
        val mid = (l + r) / 2
        println(mid)
        System.out.flush()
        val response = readln()
        when (response) {
            "wet" -> {
                l = mid + 1
            }

            "ok" -> {
                r = mid
            }
        }
    }
    return l
}