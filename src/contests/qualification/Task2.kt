package contests.qualification

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val graph = HashMap<Int, HashSet<Int>>()
    val graphVal = HashMap<Int, Int>()
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph.putIfAbsent(a, HashSet())
        graph[a]!!.add(b)
    }

    val toVisit = ArrayDeque<Int>()
    toVisit.add(1)

}