package contests.icpcTrain1

fun main() {
    val perMonth1 = readln().toInt()
    val x = readln().toInt()
    val perMonth2 = readln().toInt()
    val y = readln().toInt()
    val timePerDay = readln().toInt()

    val minutesPerDayForFirst = maxOf(0, timePerDay - 30)
    val minutesPerDayForSecond = maxOf(0, timePerDay - 45)
    val costForFirst = perMonth1 + x * minutesPerDayForFirst * 21
    val costForSecond = perMonth2 + y * minutesPerDayForSecond * 21
    println("$costForFirst $costForSecond")
}