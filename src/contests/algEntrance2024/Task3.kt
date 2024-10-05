package contests.algEntrance2024

fun main() {
    val times = readln().toInt()
    repeat(times) {
        readln()
        val diffs = readln()
        val requests = readln()
        println(solve(diffs.split(" ").map { it.toLong() }, requests.split(" ").map { it.toLong() }))
    }
}

fun solve(dif: List<Long>, req: List<Long>): String {
    val prefMax = ArrayList<Long>()
    val pref = ArrayList<Long>()
    prefMax.add(-1)
    var sum = 0L
    pref.add(-1)
    for (i in 1..dif.size) {
        sum += dif[i - 1]
        pref.add(sum)
    }
    for (i in 1..dif.size - 1) {
        prefMax.add(maxOf(dif[i], prefMax[i - 1]))
    }
    println(prefMax)
    println(pref)
    val res = ArrayList<String>()

    for (query in req) {
        val index = binaryCeiling(prefMax, query)
        println(query.toString() + " " + index)
        res.add(pref[index].toString())
    }
    return res.joinToString(separator = " ")
}

fun binaryCeiling(list: List<Long>, key: Long): Int {
    val ret = list.binarySearch(key)

    return if (ret >= 0) {
        var idx = ret
        while (idx < list.size && list[idx] == key) {
            idx++
        }
        if (idx < list.size) idx else list.size
    } else {
        val insertionPoint = -ret - 1
        insertionPoint
    }
}