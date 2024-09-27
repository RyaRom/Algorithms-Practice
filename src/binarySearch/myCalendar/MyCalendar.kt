package binarySearch.myCalendar

import java.util.*

fun main() {
    val calendar = MyCalendar()
    println(calendar.book(47, 50))
    println(calendar.book(33, 41))
}

class MyCalendar {
    private class Interval(val start: Int, val end: Int) : Comparable<Interval> {
        override fun compareTo(other: Interval): Int {
            return start.compareTo(other.start)
        }
    }

    private val events = TreeSet<Interval>()

    fun book(start: Int, end: Int): Boolean {
        val interval = Interval(start, end)
        if (validateEvent(interval)) {
            events.add(interval)
            return true
        } else {
            return false
        }
    }

    private fun validateEvent(interval: Interval): Boolean {
        val previous = events.floor(interval)
        val next = events.ceiling(interval)

        if (next == null && previous == null) return true
        if (previous == null) return next!!.start >= interval.end
        if (next == null) return previous.end <= interval.start

        return previous != next && previous.end <= interval.start && next.start >= interval.end
    }
}

class MyCalendarTwo() {

    fun book(start: Int, end: Int): Boolean {
        return true
    }

}