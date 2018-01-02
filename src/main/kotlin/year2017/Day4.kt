package year2017

class Day4 {
    fun doIt(input: String): Int {
        val lines = input.split(delimiters = *arrayOf("\n"))

        return lines.filter {
            val words = it.split(" ")

            val tempList = ArrayList<String>()
            val numberOfConflicts = words.filter {
                if (tempList.contains(it)) {
                    true
                } else {
                    tempList.add(it)
                    false
                }
            }.count()

            numberOfConflicts == 0
        }.count()
    }

    fun doItBetter(input: String): Int {
        val lines = input.split(delimiters = *arrayOf("\n"))

        return lines.filter {
            val words = it.split(" ")

            val tempList = ArrayList<String>()
            val numberOfConflicts = words.filter {
                val element = it.toAnagram()

                if (tempList.contains(element)) {
                    true
                } else {
                    tempList.add(element)
                    false
                }
            }.count()

            print(numberOfConflicts)
            numberOfConflicts == 0
        }.count()
    }
}

private fun String.toAnagram(): String {
    return this.toCharArray().sortedWith(Comparator { o1, o2 -> o1.compareTo(o2) }).joinToString(separator = "")
}
