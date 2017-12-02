package day1

class Day1 {
    fun doIt(input: String): Int {
        if (input.length < 2) return 0

        var sum =0
        val numbers = input.map { it.toString().toInt() }

        val last = numbers[numbers.size - 1]
        numbers.fold(last, {previous:Int, new:Int ->
            if (previous==new) sum+=previous
            new })

        return sum
    }
}