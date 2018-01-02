package year2017

import kotlin.math.absoluteValue
import kotlin.math.roundToInt
import kotlin.math.sqrt

class Day3 {

    fun doIt(input: Int): Int {
        val (centralPoint, grid) = prepareGrid(input)

        return fillGrid(Pair(centralPoint, centralPoint), input, grid)
    }

    fun doItBetter(input: Int): Int {
        val (centralPoint, grid) = prepareGrid(input)

        return fillGridAndBreakWhenInputReached(Pair(centralPoint, centralPoint), input, grid)
    }

    private fun fillGrid(startPoint: Pair<Int, Int>, size: Int, grid: Array<Array<Int>>): Int {
        if (size == 1) return 0

        grid[startPoint.first][startPoint.second] = 1

        var next = Pair(startPoint.first, startPoint.second + 1)

        lateinit var result: Pair<Int, Int>

        (2..size)
                .forEach {
                    grid[next.first][next.second] = it

                    if (size == it) {
                        result = next
                    } else {
                        next = if (grid[next.first][next.second - 1] != 0 && grid[next.first - 1][next.second] == 0) {
                            Pair(next.first - 1, next.second)
                        } else if (grid[next.first + 1][next.second] != 0) {
                            Pair(next.first, next.second - 1)
                        } else if (grid[next.first][next.second + 1] != 0) {
                            Pair(next.first + 1, next.second)
                        } else {
                            Pair(next.first, next.second + 1)
                        }
                    }
                }

        return (startPoint.first - result.first).absoluteValue + (startPoint.second - result.second).absoluteValue
    }

    private fun fillGridAndBreakWhenInputReached(startPoint: Pair<Int, Int>, size: Int, grid: Array<Array<Int>>): Int {
        if (size == 1) return 0

        grid[startPoint.first][startPoint.second] = 1

        var next = Pair(startPoint.first, startPoint.second + 1)

        (2..size)
                .forEach {
                    grid[next.first][next.second] = fillPlace(next, grid)


                    if (grid[next.first][next.second] > size) {
                        return grid[next.first][next.second]
                    } else {
                        next = if (grid[next.first][next.second - 1] != 0 && grid[next.first - 1][next.second] == 0) {
                            Pair(next.first - 1, next.second)
                        } else if (grid[next.first + 1][next.second] != 0) {
                            Pair(next.first, next.second - 1)
                        } else if (grid[next.first][next.second + 1] != 0) {
                            Pair(next.first + 1, next.second)
                        } else {
                            Pair(next.first, next.second + 1)
                        }
                    }
                }

        return 0
    }

    private fun fillPlace(next: Pair<Int, Int>, grid: Array<Array<Int>>): Int {
        return grid[next.first - 1][next.second - 1] +
                grid[next.first - 1][next.second] +
                grid[next.first - 1][next.second + 1] +
                grid[next.first][next.second - 1] +
                grid[next.first][next.second] +
                grid[next.first][next.second + 1] +
                grid[next.first + 1][next.second - 1] +
                grid[next.first + 1][next.second] +
                grid[next.first + 1][next.second + 1]
    }

    private fun prepareGrid(input: Int): Pair<Int, Array<Array<Int>>> {
        var size = sqrt(input.toDouble()).roundToInt()
        size += 2

        if (size.isEven()) {
            size += 1
        }

        val centralPoint = (size / 2)

        val grid = Array(size, { Array(size, { 0 }) })
        return Pair(centralPoint, grid)
    }
}

private fun Array<Array<Int>>.print() {
    this.forEach {
        it.forEach { print("$it ") }
        kotlin.io.println()
    }
    kotlin.io.println()
}

private fun Int.isEven(): Boolean {
    return this % 2 == 0
}
