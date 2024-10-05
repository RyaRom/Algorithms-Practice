package contests.algEntrance2024

fun main() {
    val times = readln().toInt()
    repeat(times) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        println(dp(n, k))
    }
}

fun dp(n: Int, k: Int): Long {
    val dp = LongArray(n + 1)
    dp[0] = 1

    var sum = 0L
    for (i in 1..n) {
        if (i <= k) {
            sum += dp[i - 1]
        } else {
            sum += dp[i - 1]
            sum -= dp[i - k - 1]
        }
        dp[i] = sum % 1000000007
    }

    return dp[n]
}