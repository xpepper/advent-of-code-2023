package day01

import streamFile
import java.util.stream.Stream

fun main() {
    streamFile("/day01-calibration.txt") { stream: Stream<String> ->
        var sum = 0
        stream.use {
            it.forEach { line: String ->
                val firstDigit = firstDigitFrom(line)
                val lastDigit = lastDigitFrom(line)
                sum += (firstDigit + lastDigit).toInt()
            }
        }
        println(sum)
    }
}

private fun firstDigitFrom(line: String) = line.find { it.isDigit() }?.toString() ?: ""

private fun lastDigitFrom(line: String) = line.reversed().find { it.isDigit() }?.toString() ?: ""
