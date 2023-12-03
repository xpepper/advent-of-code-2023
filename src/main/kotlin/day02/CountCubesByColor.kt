package day02

import java.util.Locale

fun countCubesByColor(sample: String): Map<CubeColor, Int> {
    // sample: 5 blue, 4 red, 13 green
    val cubeCountedByColor = mutableMapOf<CubeColor, Int>()
    val regex = Regex("(\\d+)\\s+(\\w+)")
    regex.findAll(sample).forEach { matchResult ->
        val count = matchResult.groupValues[1].toInt()
        val color = matchResult.groupValues[2]
        cubeCountedByColor[CubeColor.valueOf(color.capitalize())] = count
    }
    return cubeCountedByColor
}

private fun String.capitalize() =
    replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
