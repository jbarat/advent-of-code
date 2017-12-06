package year2017

class Day1 {
    fun doIt(input: String): Int {
        if (input.length < 2) return 0

        var sum = 0
        val numbers = input.map { it.toString().toInt() }

        val last = numbers[numbers.size - 1]
        numbers.fold(last, { previous: Int, new: Int ->
            if (previous == new) sum += previous
            new
        })

        return sum
    }

    fun doItBetter(input: String): Int {
        if (input.length < 2) return 0

        var sum = 0
        val pivot = input.length / 2
        val numbers = input.map { it.toString().toInt() }

        numbers.forEachIndexed { index: Int, i: Int ->
            if (i == numbers[(index + pivot) % input.length]) {
                sum += i
            }
        }

        return sum
    }
}