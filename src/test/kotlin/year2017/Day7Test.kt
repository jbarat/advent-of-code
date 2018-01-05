package year2017

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day7Test : Spek({
    given("a day 7 Recursive Circus Part 1") {
        val day = Day7()

        val input = "pbga (66)\n" +
                "xhth (57)\n" +
                "ebii (61)\n" +
                "havc (66)\n" +
                "ktlj (57)\n" +
                "fwft (72) -> ktlj, cntj, xhth\n" +
                "qoyq (66)\n" +
                "padx (45) -> pbga, havc, qoyq\n" +
                "tknk (41) -> ugml, padx, fwft\n" +
                "jptl (61)\n" +
                "ugml (68) -> gyxo, ebii, jptl\n" +
                "gyxo (61)\n" +
                "cntj (57)\n"
        on("the input $input") {
            val result = "tknk"
            it("is $result") {
                Assertions.assertThat(day.doIt(input)).isEqualTo(result)
            }
        }
        on("the input ${Day7Input.input}") {
            val result = "aapssr"
            it("is $result") {
                Assertions.assertThat(day.doIt(Day7Input.input)).isEqualTo(result)
            }
        }
    }
    given("a day 7 Recursive Circus Part 2") {
        val day = Day7()

        val input = "pbga (66)\n" +
                "xhth (57)\n" +
                "ebii (61)\n" +
                "havc (66)\n" +
                "ktlj (57)\n" +
                "fwft (72) -> ktlj, cntj, xhth\n" +
                "qoyq (66)\n" +
                "padx (45) -> pbga, havc, qoyq\n" +
                "tknk (41) -> ugml, padx, fwft\n" +
                "jptl (61)\n" +
                "ugml (68) -> gyxo, ebii, jptl\n" +
                "gyxo (61)\n" +
                "cntj (57)\n"
        on("the input $input") {
            val result = 60
            it("is $result") {
                Assertions.assertThat(day.thisOneSucks(input)).isEqualTo(result)
            }
        }
        on("the input ${Day7Input.input}") {
            val result = 1458
            it("is $result") {
                Assertions.assertThat(day.thisOneSucks(Day7Input.input)).isEqualTo(result)
            }
        }
    }
})