package contests.algEntrance2024

fun main() {
    val times = readln().toInt()
    repeat(times) {
        val n = readln().toInt()
        println(solve(n))
    }
}

fun solve(n: Int): String {
    var operationsCount = n + 1
    var operationsType = 1
    val matrix = Array(n) { IntArray(n) { 0 } }
    val operations = ArrayList<ArrayList<Int>>()
    while (operationsCount > 0) {
        if (operationsType == 1) {
            val cnt = if (operationsCount == n + 1) n - 1 else operationsCount - 1
            for (row in 0..cnt) {
                val operation = arrayListOf(operationsType, row + 1)
                for (i in 0..n - 1) {
                    operation.add(i + 1)
                    matrix[row][i] = i + 1
                }
                operations.add(operation)
            }
            operationsType = 2
            operationsCount /= 2
        } else {
            val cnt = if (operationsCount == n + 1) n - 1 else operationsCount - 1
            for (col in 0..cnt) {
                val operation = arrayListOf(operationsType, col + 1)
                for (i in 0..n - 1) {
                    operation.add(i + 1)
                    matrix[i][col] = i + 1
                }
                operations.add(operation)
            }
            operationsType = 1
            operationsCount /= 2
        }
    }

    var sum = 0
    for (row in matrix) {
        for (e in row) {
            sum += e
        }
    }
    val opStr = operations
        .joinToString(separator = "\n") { it.joinToString(separator = " ") { i -> i.toString() } }
    return "$sum ${operations.size}\n$opStr"
}