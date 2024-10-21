package contests.icpcTrain2

fun main() {
    val t = readln().toInt()
    repeat(t) {
        readln()
        val nums = readln().split(" ").map { it.toInt() }
        val freq = HashMap<Int, Int>()
        freq[nums[0]] = 1
        val unique = nums[0]
        var isUnique = true
        for (i in 1..nums.lastIndex) {
            if (nums[i] != unique) {
                isUnique = false
            }
            if (nums[i] != nums[i - 1]) {
                freq[nums[i]] = freq.getOrDefault(nums[i], 0) + 1
            }
        }
        freq[nums.last()] = freq[nums.last()]!! - 1
        freq[nums.first()] = freq[nums.first()]!! - 1
        var min = 1000000000
        for (n in freq.keys) {
            min = minOf(min, freq[n]!!)
        }
        if (isUnique) {
            println(0)
        } else {
            println(min + 1)
        }
    }
}