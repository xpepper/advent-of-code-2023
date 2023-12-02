package day01

import streamFile

fun main() {
    streamFile("/day01-calibration.txt") { stream ->
        var counter = 0
        stream.forEach { line ->
            val firstDigit = firstDigitFrom(line)
            val lastDigit = lastDigitFrom(line)
            counter += (firstDigit + lastDigit).toInt()
        }
        println(counter)
    }
}

private fun firstDigitFrom(line: String): String? {
    val firstDigitAsDigit = line.find { it.isDigit() }?.toString()
    var firstDigit = firstDigitAsDigit
    val firstDigitAsLetter = digitsAsLetters.map {
        it to line.indexOf(it)
    }.filter { it.second >= 0 }.minByOrNull { it.second }
    if (firstDigitAsLetter != null && firstDigitAsDigit != null) {
        if (firstDigitAsLetter.second < line.indexOf(firstDigitAsDigit))
            firstDigit = firstDigitAsLetter.first.toDigit().toString()
    }
    if (firstDigitAsDigit == null) {
        firstDigit = firstDigitAsLetter?.first?.toDigit().toString()
    }
    return firstDigit
}

private fun lastDigitFrom(line: String): String {
    val lastDigitAsDigit = line.reversed().find { it.isDigit() }?.toString() ?: ""
    var lastDigit = lastDigitAsDigit
    val lastDigitAsLetter = digitsAsLetters.map {
        it to line.lastIndexOf(it)
    }.filter { it.second >= 0 }.maxByOrNull { it.second }
    if (lastDigitAsLetter != null && lastDigitAsDigit != null) {
        if (lastDigitAsLetter.second > line.lastIndexOf(lastDigitAsDigit))
            lastDigit = lastDigitAsLetter.first.toDigit().toString()
    }
    if (lastDigitAsDigit == null) {
        lastDigit = lastDigitAsLetter?.first?.toDigit().toString()
    }
    return lastDigit
}

private fun String.toDigit(): Int = when (this) {
    "one" -> 1
    "two" -> 2
    "three" -> 3
    "four" -> 4
    "five" -> 5
    "six" -> 6
    "seven" -> 7
    "eight" -> 8
    "nine" -> 9
    else -> throw UnsupportedOperationException("Invalid digit $this")
}

val digitsAsLetters = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
