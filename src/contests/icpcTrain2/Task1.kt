package contests.icpcTrain2

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val ans = mutableListOf<Int>()
        for (i in n downTo 1) {
            ans.add(i)
        }
        val temp = ans[n / 2]
        ans[n / 2] = ans[n / 2 - 1]
        ans[n / 2 - 1] = temp
        println(ans.joinToString(" ") { it.toString() })
    }
}