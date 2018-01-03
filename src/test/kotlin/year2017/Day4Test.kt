package year2017

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day4Test : Spek({
    given("a day 4 High-Entropy Passphrases") {
        val day = Day4()

        val input = "aa bb cc dd ee"
        on("the input $input") {
            val result = 1
            it("is $result") {
                Assertions.assertThat(day.doIt(input)).isEqualTo(result)
            }
        }
        val input2 = "aa bb cc dd aa"
        on("the input $input2") {
            val result = 0
            it("is $result") {
                Assertions.assertThat(day.doIt(input2)).isEqualTo(result)
            }
        }
        val input3 = "aa bb cc dd aaa"
        on("the input $input3") {
            val result = 1
            it("is $result") {
                Assertions.assertThat(day.doIt(input3)).isEqualTo(result)
            }
        }

        on("the input ${Day4Input.input}") {
            val result = 386
            it("is $result") {
                Assertions.assertThat(day.doIt(Day4Input.input)).isEqualTo(result)
            }
        }
    }

    given("a day 4 Complex High-Entropy Passphrases") {
        val day = Day4()

        val input = "abcde fghij"
        on("the input $input") {
            val result = 1
            it("is $result") {
                Assertions.assertThat(day.doItBetter(input)).isEqualTo(result)
            }
        }

        val input2 = "abcde xyz ecdab"
        on("the input $input2") {
            val result = 0
            it("is $result") {
                Assertions.assertThat(day.doItBetter(input2)).isEqualTo(result)
            }
        }

        val input3 = "a ab abc abd abf abj"
        on("the input $input3") {
            val result = 1
            it("is $result") {
                Assertions.assertThat(day.doItBetter(input3)).isEqualTo(result)
            }
        }

        val input4 = "iiii oiii ooii oooi oooo"
        on("the input $input4") {
            val result = 1
            it("is $result") {
                Assertions.assertThat(day.doItBetter(input4)).isEqualTo(result)
            }
        }

        val input5 = "oiii ioii iioi iiio"
        on("the input $input5") {
            val result = 0
            it("is $result") {
                Assertions.assertThat(day.doItBetter(input5)).isEqualTo(result)
            }
        }

        on("the input ${Day4Input.input}") {
            val result = 208
            it("is $result") {
                Assertions.assertThat(day.doItBetter(Day4Input.input)).isEqualTo(result)
            }
        }
    }
})