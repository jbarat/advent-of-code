package year2017

class Day2 {
    fun doIt(input: String): Int {
        var sum = 0
        input.split(delimiters = *charArrayOf('\n'))
                .forEach {
                    var min = Int.MAX_VALUE
                    var max = Int.MIN_VALUE
                    it.split(delimiters = *charArrayOf(' ', '\t'))
                            .map { it.toInt() }
                            .forEach {
                                if (it < min) min = it
                                if (it > max) max = it
                            }

                    sum += (max - min)
                }

        return sum
    }

    fun doItBetter(input: String): Int {
        var sum = 0
        input.split(delimiters = *charArrayOf('\n'))
                .forEach {
                    val sortedRow = it.split(delimiters = *charArrayOf(' ', '\t'))
                            .map { it.toInt() }
                            .sortedBy { it }

                    sortedRow.forEach { current ->
                        sortedRow.filter {
                            it != current && it % current == 0
                        }.map {
                            sum += it / current
                        }
                    }

                }

        return sum
    }

}