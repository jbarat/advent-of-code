package year2017

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class Day8Test : Spek({
    given("a day 8 Heard You Like Registers Part 1") {
        val day = Day8()

        val input = "b inc 5 if a > 1\n" +
                "a inc 1 if b < 5\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10"
        on("the input $input") {
            val result = 1
            it("is $result") {
                Assertions.assertThat(day.doIt(input)).isEqualTo(result)
            }
        }
        on("the input ${Day8Input.input}") {
            val result = 4163
            it("is $result") {
                Assertions.assertThat(day.doIt(Day8Input.input)).isEqualTo(result)
            }
        }
    }

    given("a day 8 Heard You Like Registers Part 2") {
        val day = Day8()

        val input = "b inc 5 if a > 1\n" +
                "a inc 1 if b < 5\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10"
        on("the input $input") {
            val result = 10
            it("is $result") {
                Assertions.assertThat(day.doItBetter(input)).isEqualTo(result)
            }
        }
        on("the input ${Day8Input.input}") {
            val result = 5347
            it("is $result") {
                Assertions.assertThat(day.doItBetter(Day8Input.input)).isEqualTo(result)
            }
        }
    }
})

