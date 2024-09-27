package binarySearch.myCalendar

import java.util.*

fun main() {
    val calendar = MyCalendarTwo()
    println(calendar.book(1, 4))
    println(calendar.book(3, 5))
    println(calendar.book(3, 5))
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

class MyCalendarTwo {
    private val events = TreeSet<Interval>()
    private val doubleBooked = TreeSet<Interval>()

    fun book(start: Int, end: Int): Boolean {
        val newEvent = Interval(start, end)

        for (db in doubleBooked) {
            if (newEvent.overlap(db)) {
                return false
            }
        }

        for (e in events) {
            if (newEvent.overlap(e)) {
                doubleBooked.add(newEvent.intersection(e))
            }
        }

        events.add(newEvent)
        return true
    }

    private class Interval(val start: Int, val end: Int) : Comparable<Interval> {
        override fun compareTo(other: Interval): Int {
            return start.compareTo(other.start)
        }

        fun overlap(other: Interval): Boolean {
            return this.start < other.end && other.start < this.end
        }

        fun intersection(other: Interval): Interval {
            return Interval(maxOf(this.start, other.start), minOf(this.end, other.end))
        }
    }
}
