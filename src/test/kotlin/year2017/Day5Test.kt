package year2017

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


object Day5Test : Spek({
    given("a day 5 A Maze of Twisty Trampolines Part 1") {
        val day = Day5()

        val input = "0\n" +
                "3\n" +
                "0\n" +
                "1\n" +
                "-3"
        on("the input $input") {
            val result = 5
            it("is $result") {
                Assertions.assertThat(day.doIt(input)).isEqualTo(result)
            }
        }
        on("the input ${Day5Input.input}") {
            val result = 372671
            it("is $result") {
                Assertions.assertThat(day.doIt(Day5Input.input)).isEqualTo(result)
            }
        }
    }
    given("a day 5 A Maze of Twisty Trampolines Part 2") {
        val day = Day5()

        val input = "0\n" +
                "3\n" +
                "0\n" +
                "1\n" +
                "-3"
        on("the input $input") {
            val result = 10
            it("is $result") {
                Assertions.assertThat(day.doItBetter(input)).isEqualTo(result)
            }
        }
        on("the input ${Day5Input.input}") {
            val result = 25608480
            it("is $result") {
                Assertions.assertThat(day.doItBetter(Day5Input.input)).isEqualTo(result)
            }
        }
    }
})