package contests.icpcTrain1

import java.math.BigInteger

fun main() {
    val factorials = countFactorials()
    val (n, k) = readln().split(" ").map { it.toInt() }
    var first = 0
    var second = k
    var count = BigInteger.ZERO
    while (first <= second) {
        count += countVariants(n, first, factorials)
        count += countVariants(n, second, factorials)
        second--
        first++
    }
    println(count)
}

fun countVariants(n: Int, k: Int, factorials: Array<BigInteger>): BigInteger {
    if (k == 0 || n == k) return BigInteger.ONE
    return if (n % 2 == 0) {
        binomial(n, k, factorials) / BigInteger.TWO
    } else {
        (binomial(n, k, factorials) / BigInteger.TWO) + BigInteger.ONE
    }
}

fun countFactorials(): Array<BigInteger> {
    val factorials = Array<BigInteger>(51) { BigInteger.ONE }
    for (i in 1 until factorials.size) {
        factorials[i] = factorials[i - 1].multiply(BigInteger.valueOf(i.toLong()))
    }
    return factorials
}

fun binomial(n: Int, k: Int, factorials: Array<BigInteger>): BigInteger {
    return factorials[n] / (factorials[k] * factorials[n - k])
}