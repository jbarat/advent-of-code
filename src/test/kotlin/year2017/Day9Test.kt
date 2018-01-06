package year2017

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class Day9Test : Spek({
    given("a day 9 Stream Processing Part 1") {
        val day = Day9()

        val input = "{}"
        on("the input $input") {
            val result = 1
            it("is $result") {
                Assertions.assertThat(day.doIt(input)).isEqualTo(result)
            }
        }
        val input2 = "{{{}}}"
        on("the input $input2") {
            val result = 6
            it("is $result") {
                Assertions.assertThat(day.doIt(input2)).isEqualTo(result)
            }
        }
        val input3 = "{{},{}}"
        on("the input $input3") {
            val result = 5
            it("is $result") {
                Assertions.assertThat(day.doIt(input3)).isEqualTo(result)
            }
        }
        val input4 = "{{{},{},{{}}}}"
        on("the input $input4") {
            val result = 16
            it("is $result") {
                Assertions.assertThat(day.doIt(input4)).isEqualTo(result)
            }
        }
        val input5 = "{<a>,<a>,<a>,<a>}"
        on("the input $input5") {
            val result = 1
            it("is $result") {
                Assertions.assertThat(day.doIt(input5)).isEqualTo(result)
            }
        }
        val input6 = "{{<ab>},{<ab>},{<ab>},{<ab>}}"
        on("the input $input6") {
            val result = 9
            it("is $result") {
                Assertions.assertThat(day.doIt(input6)).isEqualTo(result)
            }
        }
        val input7 = "{{<!!>},{<!!>},{<!!>},{<!!>}}"
        on("the input $input7") {
            val result = 9
            it("is $result") {
                Assertions.assertThat(day.doIt(input7)).isEqualTo(result)
            }
        }
        val input8 = "{{<a!>},{<a!>},{<a!>},{<ab>}}"
        on("the input $input8") {
            val result = 3
            it("is $result") {
                Assertions.assertThat(day.doIt(input8)).isEqualTo(result)
            }
        }
        on("the input ${Day9Input.input}") {
            val result = 11347
            it("is $result") {
                Assertions.assertThat(day.doIt(Day9Input.input)).isEqualTo(result)
            }
        }
    }
    given("a day 9 Stream Processing Part 2") {
        val day = Day9()

        val input = "<{o\"i!a,<{i<a>"
        on("the input input") {
            val result = 10
            it("is $result") {
                Assertions.assertThat(day.doItBetter(input)).isEqualTo(result)
            }
        }

        on("the input ${Day9Input.input}") {
            val result = 5404
            it("is $result") {
                Assertions.assertThat(day.doItBetter(Day9Input.input)).isEqualTo(result)
            }
        }
    }
})