package contests.algEntrance2024

fun main() {
    readln()
    val n = readln().split(" ").map { it.toInt() }
    solve(n)
}

fun solve(blame: List<Int>) {
    var solution = ""
    for (personIndex in blame.indices) {
        var currentPerson = blame[personIndex]
        val visited = HashSet<Int>()
        visited.add(personIndex + 1)
        while (visited.add(currentPerson)) {
            currentPerson = blame[currentPerson - 1]
        }
        solution += "$currentPerson "
    }
    print(solution.trim())
}