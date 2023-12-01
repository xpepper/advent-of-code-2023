package day1

import java.nio.file.Files
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path

@ExperimentalPathApi
fun main() {
    val url = {}.javaClass.getResource("/calibration.txt")
    val path = Path(url.path)
    var counter = 0
    Files.newBufferedReader(path).use { reader ->
        reader.lines().forEach { line ->
            val firstDigit = line.find { it.isDigit() }?.toString()
            var realFirstDigit = firstDigit
            val firstDigitAsLetter = digitsAsLetters.map {
                it to line.indexOf(it)
            }.filter { it.second >= 0 }.minByOrNull { it.second }
            if (firstDigitAsLetter != null && firstDigit != null) {
                if (firstDigitAsLetter.second < line.indexOf(firstDigit))
                    realFirstDigit = firstDigitAsLetter.first.toDigit().toString()
            }
            if (firstDigit == null) {
                realFirstDigit = firstDigitAsLetter?.first?.toDigit().toString()
            }

            val lastDigit = line.reversed().find { it.isDigit() }?.toString() ?: ""
            var realLastDigit = lastDigit
            val lastDigitAsLetter = digitsAsLetters.map {
                it to line.lastIndexOf(it)
            }.filter { it.second >= 0 }.maxByOrNull { it.second }
            if (lastDigitAsLetter != null && lastDigit != null) {
                if (lastDigitAsLetter.second > line.lastIndexOf(lastDigit))
                    realLastDigit = lastDigitAsLetter.first.toDigit().toString()
            }
            if (lastDigit == null) {
                realLastDigit = lastDigitAsLetter?.first?.toDigit().toString()
            }

            counter += (realFirstDigit + realLastDigit).toInt()
        }
    }
    println(counter)
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
