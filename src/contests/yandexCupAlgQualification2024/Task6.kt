package contests.yandexCupAlgQualification2024

fun main() {
    val n = 2025
    val k = 11
    val t = readln().toInt()
    println(k)
    for (bit in 0 until k) {
        val question = mutableListOf<Int>()
        for (i in 0 until n) {
            if ((i shr bit) and 1 == 1) {
                question.add(i)
            }
        }
        println(question.joinToString(" "))
    }
    System.out.flush()

    val answers = Array(t) {
        readln().split(" ").map { it.toInt() }
    }
    if (answers.any { it.contains(-1) }) {
        return
    }

    for (i in 0 until t) {
        var result = 0
        for (bit in 0 until k) {
            if (answers[i][bit] == 1) {
                result = result or (1 shl bit)
            }
        }
        println(result)
    }
}
