package year2017

class Day6 {
    fun doIt(input: String): Int {
        val alreadyVisited = ArrayList<String>()

        var iteration = 0
        val current = input.split("\t").map { it.toInt() }.toMutableList()
        while (!alreadyVisited.contains(current.joinToString())) {
            alreadyVisited.add(current.joinToString())

            val biggestIndex = biggestElementIndex(current)
            var amountToRedistribute = current[biggestIndex]

            current[biggestIndex] = 0

            var redistributionIndex = biggestIndex + 1
            while (amountToRedistribute > 0) {
                current[redistributionIndex % current.size]++

                redistributionIndex++
                amountToRedistribute--
            }

            iteration++
        }

        return iteration
    }

    fun doItBetter(input: String): Int {
        val alreadyVisited = ArrayList<String>()

        val current = input.split("\t").map { it.toInt() }.toMutableList()
        while (!alreadyVisited.contains(current.joinToString())) {
            alreadyVisited.add(current.joinToString())

            val biggestIndex = biggestElementIndex(current)
            var amountToRedistribute = current[biggestIndex]

            current[biggestIndex] = 0

            var redistributionIndex = biggestIndex + 1
            while (amountToRedistribute > 0) {
                current[redistributionIndex % current.size]++

                redistributionIndex++
                amountToRedistribute--
            }
        }

        return alreadyVisited.size - alreadyVisited.indexOfFirst { it == current.joinToString() }
    }

    private fun biggestElementIndex(current: List<Int>): Int {
        var biggestIndex = 0

        current.forEachIndexed { index, i -> if (i > current[biggestIndex]) biggestIndex = index }

        return biggestIndex
    }

}