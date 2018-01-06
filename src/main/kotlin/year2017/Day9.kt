package year2017

class Day9 {

    fun doIt(input: String): Int {
        return reallyDoIt(input).part1
    }

    fun doItBetter(input: String): Int {
        return reallyDoIt(input).part2
    }

    private fun reallyDoIt(input: String): Result {
        val result = Result()

        var level = 0
        var junk = false
        var skip = false

        input.forEach {
            when {
                skip -> skip = false
                it == '!' -> skip = true
                junk -> when (it) {
                    '>' -> junk = false
                    else -> result.part2 += 1
                }
                else -> when (it) {
                    '{' -> {
                        level += 1
                    }
                    '}' -> {
                        result.part1 += level
                        level -= 1
                    }
                    '<' -> {
                        junk = true
                    }
                }
            }
        }

        return result
    }

    private data class Result(
            var part1: Int = 0,
            var part2: Int = 0
    )
}