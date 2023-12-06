package day04

import kotlin.math.pow

fun main() {
    scratchcards.sumOf { row ->
        val (winningNumbers, myNumbers) = row.split(":")[1].trim().split("|")
            .map { it.split(" ").filterNot(String::isBlank).map(String::toInt) }

        val matchingNumbers = myNumbers.intersect(winningNumbers.toSet())
        2.0.pow(matchingNumbers.size - 1).toInt()
    }.also(::println)
}
