package day1

import streamFile

fun main() {
    streamFile("/calibration.txt") { stream ->
        var counter = 0
        stream.forEach { line ->
            val firstDigit = firstDigitFrom(line)
            val lastDigit = lastDigitFrom(line)
            counter += (firstDigit + lastDigit).toInt()
        }
        println(counter)
    }
}

private fun lastDigitFrom(line: String) = line.reversed().find { it.isDigit() }?.toString() ?: ""

private fun firstDigitFrom(line: String) = line.find { it.isDigit() }?.toString() ?: ""
