package contests.kotlinHeroesPractice2024

fun main() {
    val n = readln().toInt()
    for (i in 0..n - 1) {
        readln()
        val str = readln()
        if (validateStr(str)) println("YES")
        else println("NO")
    }
}

fun validateStr(str: String): Boolean {
    if (str == "1" || str == "1111") return true
    val chars = str.toCharArray()
    var side = 0
    for (c in chars) {
        if (c == '1') side++
        else break
    }
    side--
    if (side < 3) return false

    var last = 0
    for (i in 1..side - 2) {
        var j = side * i
        if (j == chars.size || chars[j] != '1') return false
        for (k in 1 until side - 1) {
            if (j + k == chars.size || chars[j + k] != '0') return false
        }
        j += side - 1
        if (j == chars.size || chars[j] != '1') return false
        last = j + 1
    }

    if (last > chars.size - 1) return false
    for (i in last..last + side - 1) {
        if (i == chars.size || chars[i] != '1') return false
    }
    return true
}