package contests.yandexCupAlgQualification2024

import kotlin.math.abs

fun main() {
    val command = readln()
    var r = 0
    var l = 0
    var unknown = 0
    for (c in command) {
        when (c) {
            'R' -> r++
            'L' -> l++
            '?' -> unknown++
        }
    }
    val known = if (r > l) 'R' else 'L'
    var width = 0
    var max = 0
    var min = 0

    for (c in command) {
        var ch = c
        if (c == '?') ch = known
        if (ch == 'R') width++ else width--
        max = maxOf(max, width)
        min = minOf(min, width)
    }
    val known2 = if (known == 'R') 'L' else 'R'
    var width2 = 0
    var max2 = 0
    var min2 = 0

    for (c in command) {
        var ch = c
        if (c == '?') ch = known2
        if (ch == 'R') width2++ else width2--
        max2 = maxOf(max2, width2)
        min2 = minOf(min2, width2)
    }
    println(maxOf(abs(max - min), abs(max2 - min2)))
}