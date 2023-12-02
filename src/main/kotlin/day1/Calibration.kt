package day1

import streamFile
import kotlin.io.path.ExperimentalPathApi

@ExperimentalPathApi
fun main() {
    streamFile("/calibration.txt") { stream ->
        var counter = 0
        stream.forEach { line ->
            val firstDigit = line.find { it.isDigit() }?.toString() ?: ""
            val lastDigit = line.reversed().find { it.isDigit() }?.toString() ?: ""
            counter += (firstDigit + lastDigit).toInt()
        }
        println(counter)
    }
}
