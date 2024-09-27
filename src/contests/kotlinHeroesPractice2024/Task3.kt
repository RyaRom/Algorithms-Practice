package contests.kotlinHeroesPractice2024

fun main() {
    val n = readln().toInt()
    for (t in 1..n) {
        readln()
        var leftChunkSize = 0
        var rightChunkSize = 0
        val arr = readln().split(" ")
        var chunk = arr.first()

        var flag = true
        for (i in arr.indices) {
            if (arr[i] != chunk) {
                leftChunkSize = i
                flag = false
                break
            }
        }
        if (flag) {
            println(0)
            continue
        }

        for (i in arr.indices.reversed()) {
            if (arr[i] != chunk) {
                rightChunkSize = arr.size - i - 1
                break
            }
        }

        val middle = arr.size - leftChunkSize - rightChunkSize

        leftChunkSize = 0
        rightChunkSize = 0
        chunk = arr.last()

        flag = true
        for (i in arr.indices.reversed()) {
            if (arr[i] != chunk) {
                rightChunkSize = arr.size - i - 1
                flag = false
                break
            }
        }
        if (flag) {
            println(0)
            continue
        }

        for (i in arr.indices) {
            if (arr[i] != chunk) {
                leftChunkSize = i
                break
            }
        }

        println(minOf(arr.size - leftChunkSize - rightChunkSize, middle))
    }
}