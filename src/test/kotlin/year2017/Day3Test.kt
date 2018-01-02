package year2017

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day3Test : Spek({
    given("a day 3 Spiral Memory") {
        val day = Day3()
        on("the input 1") {
            val input = 1
            it("is 0") {
                Assertions.assertThat(day.doIt(input)).isEqualTo(0)
            }
        }
        on("the input 12") {
            val input = 12
            it("is 3") {
                Assertions.assertThat(day.doIt(input)).isEqualTo(3)
            }
        }
        on("the input 23") {
            val input = 23
            it("is 2") {
                Assertions.assertThat(day.doIt(input)).isEqualTo(2)
            }
        }
        on("the input 1024") {
            val input = 1024
            it("is 371") {
                Assertions.assertThat(day.doIt(input)).isEqualTo(31)
            }
        }
        on("the input 368078") {
            val input = 368078
            it("is 31") {
                Assertions.assertThat(day.doIt(input)).isEqualTo(371)
            }
        }

        on("the complex input 23") {
            val input = 23
            it("is 25") {
                Assertions.assertThat(day.doItBetter(input)).isEqualTo(25)
            }
        }
        on("the complex input 368078") {
            val input = 368078
            it("is 368079") {
                Assertions.assertThat(day.doItBetter(input)).isEqualTo(369601)
            }
        }

    }
})