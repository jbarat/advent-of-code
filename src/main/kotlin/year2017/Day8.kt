package year2017

class Day8 {
    fun doIt(input: String): Int {
        val register = HashMap<String, Int>()

        val instructions = input.split("\n")

        instructions.forEach {
            val instructionParts = it.split(" ")

            val selectedRegister = instructionParts[0]
            val selectedOperation = instructionParts[1].toOperation()
            val selectedOperationValue = instructionParts[2].toInt()

            val condition1 = instructionParts[4]
            val conditionOperation = instructionParts[5].toCondition()
            val condition2 = instructionParts[6]

            if (condition(condition1, condition2, conditionOperation, register)) {
                var registerValue = register[selectedRegister] ?: 0

                when (selectedOperation) {
                    Operation.INC -> registerValue += selectedOperationValue
                    Operation.DEC -> registerValue -= selectedOperationValue
                }

                register.put(selectedRegister, registerValue)
            }
        }

        return register.values.max() ?: 0
    }

    fun doItBetter(input: String): Int {
        val register = HashMap<String, Int>()

        val instructions = input.split("\n")

        var max = 0
        instructions.forEach {
            val instructionParts = it.split(" ")

            val selectedRegister = instructionParts[0]
            val selectedOperation = instructionParts[1].toOperation()
            val selectedOperationValue = instructionParts[2].toInt()

            val condition1 = instructionParts[4]
            val conditionOperation = instructionParts[5].toCondition()
            val condition2 = instructionParts[6]

            if (condition(condition1, condition2, conditionOperation, register)) {
                var registerValue = register[selectedRegister] ?: 0

                when (selectedOperation) {
                    Operation.INC -> registerValue += selectedOperationValue
                    Operation.DEC -> registerValue -= selectedOperationValue
                }

                register.put(selectedRegister, registerValue)

                if (registerValue > max) max = registerValue
            }
        }

        return max
    }

    private fun condition(condition1: String, condition2: String, conditionOperation: Condition, register: HashMap<String, Int>): Boolean {
        val registerValue = register[condition1] ?: 0

        return when (conditionOperation) {
            Condition.LESS -> registerValue < condition2.toInt()
            Condition.LESSOREQUAL -> registerValue <= condition2.toInt()
            Condition.GREATER -> registerValue > condition2.toInt()
            Condition.GREATEROREQUAL -> registerValue >= condition2.toInt()
            Condition.EQUAL -> registerValue == condition2.toInt()
            Condition.NOTEQUAL -> registerValue != condition2.toInt()
        }
    }

}

private fun String.toCondition(): Condition {
    return when (this) {
        "<" -> Condition.LESS
        "<=" -> Condition.LESSOREQUAL
        ">" -> Condition.GREATER
        ">=" -> Condition.GREATEROREQUAL
        "==" -> Condition.EQUAL
        "!=" -> Condition.NOTEQUAL
        else -> throw IllegalStateException(this)
    }
}

enum class Condition {
    LESS, LESSOREQUAL, GREATER, GREATEROREQUAL, EQUAL, NOTEQUAL
}

private fun String.toOperation(): Operation {
    return when (this) {
        "inc" -> Operation.INC
        "dec" -> Operation.DEC
        else -> throw IllegalStateException(this)
    }
}

enum class Operation {
    INC, DEC
}
