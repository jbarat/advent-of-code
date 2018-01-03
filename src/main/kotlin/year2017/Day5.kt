package year2017

class Day5 {

    fun doIt(input: String): Int {
        val list = input.split("\n").map { it.toInt() }.toMutableList()

        var index = 0
        var numberOfSteps = 0

        while (hasNext(list, index)) {
            val originalOffset = list[index]

            list[index] += 1

            index += originalOffset

            numberOfSteps++
        }

        return numberOfSteps
    }

    fun doItBetter(input: String): Int {
        val list = input.split("\n").map { it.toInt() }.toMutableList()

        var index = 0
        var numberOfSteps = 0

        while (hasNext(list, index)) {
            val originalOffset = list[index]
            list[index] += if (list[index] >= 3) -1 else 1

            index += originalOffset

            numberOfSteps++
        }

        return numberOfSteps
    }
}

private fun hasNext(list: List<Int>, index: Int): Boolean {
    return 0 <= index && index < list.size
}

private fun List<Int>.print() {
    forEach { print("$it ") }
    println()
}
