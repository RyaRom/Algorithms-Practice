package contests.icpcTrain1

fun main() {
    readln()
    val people = readln().split(" ").map { it.toInt() }.sorted()
    val peopleSorted = mutableListOf(0).apply { addAll(people) }
    val diffs = ArrayList<Int>()
    var maxDiff = 0
    for (i in 0 until peopleSorted.size - 1) {
        val diff = peopleSorted[i + 1] - peopleSorted[i]
        diffs.add(diff)
        maxDiff = maxOf(maxDiff, diff)
    }

    for (i in 0 until diffs.size - 1) {
        if (diffs[i] + diffs[i + 1] <= maxDiff) {
            println(0)
            return
        }
    }
    println(maxDiff)
}
