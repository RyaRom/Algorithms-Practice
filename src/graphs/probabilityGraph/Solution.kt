package graphs.probabilityGraph

import kotlin.math.max

fun main() {
    println(
        Solution().maxProbability(
            3,
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(2, 4),
                intArrayOf(0, 4),
                intArrayOf(0, 3),
                intArrayOf(0, 2),
                intArrayOf(2, 3)
            ),
            doubleArrayOf(0.37, 0.17, 0.93, 0.23, 0.39, 0.04),
            3,
            4
        )
    )
}

class Solution {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start_node: Int, end_node: Int): Double {
        val tryEdge = HashMap<Int, MutableList<Pair<Int, Double>>>()
        for ((i, edge) in edges.withIndex()) {
            tryEdge.putIfAbsent(edge[0], mutableListOf())
            tryEdge.putIfAbsent(edge[1], mutableListOf())
            tryEdge[edge[0]]?.add(Pair(edge[1], succProb[i]))
            tryEdge[edge[1]]?.add(Pair(edge[0], succProb[i]))
        }
        return shortestPath(tryEdge, start_node, end_node)
    }

    private fun shortestPath(edges: HashMap<Int, MutableList<Pair<Int, Double>>>, from: Int, to: Int): Double {
        val checkedNodes = mutableSetOf(from)
        val cost = HashMap<Int, Double>()
        cost[from] = 1.0
        val toCheck = ArrayDeque<Int>()
        edges[from]?.forEach() { (v, c) ->
            run {
                toCheck.add(v)
                cost[v] = c
            }
        }
        while (toCheck.isNotEmpty()) {
            val current = toCheck.first()
            toCheck.removeFirst()
            edges[current]?.let { nodes ->
                for (node in nodes) {
                    cost.putIfAbsent(node.first, 0.0)
                    cost[node.first] = max(cost[node.first]!!, cost[current]!! * node.second)
                    if (!checkedNodes.contains(node.first)) toCheck.add(node.first)
                }
            }
            checkedNodes.add(current)
        }
        return if (cost[to] == null) 0.0
        else cost[to]!!
    }
}

