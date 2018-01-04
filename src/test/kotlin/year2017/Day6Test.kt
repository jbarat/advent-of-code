package year2017

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day6Test : Spek({
    given("a day 6 Memory Reallocation Part 1") {
        val day = Day6()

        val input = "0\t2\t7\t0"
        on("the input $input") {
            val result = 5
            it("is $result") {
                Assertions.assertThat(day.doIt(input)).isEqualTo(result)
            }
        }
        on("the input ${Day6Input.input}") {
            val result = 11137
            it("is $result") {
                Assertions.assertThat(day.doIt(Day6Input.input)).isEqualTo(result)
            }
        }
    }
    given("a day 6 Memory Reallocation Part 2") {
        val day = Day6()

        val input = "0\t2\t7\t0"
        on("the input $input") {
            val result = 4
            it("is $result") {
                Assertions.assertThat(day.doItBetter(input)).isEqualTo(result)
            }
        }
        on("the input ${Day6Input.input}") {
            val result = 1037
            it("is $result") {
                Assertions.assertThat(day.doItBetter(Day6Input.input)).isEqualTo(result)
            }
        }
    }
})