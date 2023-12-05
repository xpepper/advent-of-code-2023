package day03

private const val max_index = 9

fun main() {
    // a 140x140 matrix
    val engineSchemata = listOf(
        "467..114..",
        "...*......",
        "..35..633.",
        "......#...",
        "617*......",
        ".....+.58.",
        "..592.....",
        "......755.",
        "...$.*....",
        ".664.598.."
    )
    val charArrays = engineSchemata.map { it.toCharArray() }

    val numbers = mutableListOf<Int>()
    val gearNumbers = mutableMapOf<Pair<Int, Int>, MutableList<Int>>()
    for (i in 0..max_index) {
        for (j in 0..max_index) {
            val e = charArrays[i][j]
            if (e == '*') { // star symbol found!

                // adjacent in the previous row
                if (i > 0 && charArrays[i - 1][j].isDigit()) {
                    // up
                    detectNumberIn(charArrays[i - 1], j).let {
                        if (numbers.lastOrNull() != it) {
                            numbers.add(it)
                            val orDefault = gearNumbers.getOrDefault(i to j, mutableListOf())
                            orDefault.add(it)
                            gearNumbers[i to j] = orDefault
                        }
                    }
                }
                if (i > 0 && j > 0 && charArrays[i - 1][j - 1].isDigit()) {
                    // up-left
                    detectNumberIn(charArrays[i - 1], j - 1).let {
                        if (numbers.lastOrNull() != it) {
                            numbers.add(it)
                            val orDefault = gearNumbers.getOrDefault(i to j, mutableListOf())
                            orDefault.add(it)
                            gearNumbers[i to j] = orDefault

                        }
                    }
                }
                if (i > 0 && j < max_index && charArrays[i - 1][j + 1].isDigit()) {
                    // up-right
                    detectNumberIn(charArrays[i - 1], j + 1).let {
                        if (numbers.lastOrNull() != it) {
                            numbers.add(it)
                            val orDefault = gearNumbers.getOrDefault(i to j, mutableListOf())
                            orDefault.add(it)
                            gearNumbers[i to j] = orDefault

                        }
                    }
                }

                // adjacent in the same row
                if (j > 0 && charArrays[i][j - 1].isDigit()) {
                    // previous
                    detectNumberIn(charArrays[i], j - 1).let {
                        if (numbers.lastOrNull() != it) {
                            numbers.add(it)
                            val orDefault = gearNumbers.getOrDefault(i to j, mutableListOf())
                            orDefault.add(it)
                            gearNumbers[i to j] = orDefault

                        }
                    }
                }
                if (j < max_index && charArrays[i][j + 1].isDigit()) {
                    // following
                    detectNumberIn(charArrays[i], j + 1).let {
                        if (numbers.lastOrNull() != it) {
                            numbers.add(it)
                            val orDefault = gearNumbers.getOrDefault(i to j, mutableListOf())
                            orDefault.add(it)
                            gearNumbers[i to j] = orDefault

                        }
                    }
                }

                // adjacent in the following row
                if (i < max_index && charArrays[i + 1][j].isDigit()) {
                    // down
                    detectNumberIn(charArrays[i + 1], j).let {
                        if (numbers.lastOrNull() != it) {
                            numbers.add(it)
                            val orDefault = gearNumbers.getOrDefault(i to j, mutableListOf())
                            orDefault.add(it)
                            gearNumbers[i to j] = orDefault

                        }
                    }
                }
                if (i < max_index && j > 0 && charArrays[i + 1][j - 1].isDigit()) {
                    // down-left
                    detectNumberIn(charArrays[i + 1], j - 1).let {
                        if (numbers.lastOrNull() != it) {
                            numbers.add(it)
                            val orDefault = gearNumbers.getOrDefault(i to j, mutableListOf())
                            orDefault.add(it)
                            gearNumbers[i to j] = orDefault

                        }
                    }
                }
                if (i < max_index && j < max_index && charArrays[i + 1][j + 1].isDigit()) {
                    // down-right
                    detectNumberIn(charArrays[i + 1], j + 1).let {
                        if (numbers.lastOrNull() != it) {
                            numbers.add(it)
                            val orDefault = gearNumbers.getOrDefault(i to j, mutableListOf())
                            orDefault.add(it)
                            gearNumbers[i to j] = orDefault
                        }
                    }
                }
            }
        }
    }
    gearNumbers
        .filter { it.value.size == 2 }
        .map { it.value }
        .sumOf { it.reduce { acc, eachValue -> acc * eachValue } }.also(::println)
}

private fun detectNumberIn(charArrays: CharArray, col: Int): Int {
    val stringBuilder = StringBuilder()

    var j = col
    while (charArrays[j].isDigit() && j > 0) {
        j--
    }
    if (j == 0) {
        if (!charArrays[j].isDigit()) j++
        while (charArrays[j].isDigit() && j < max_index) {
            stringBuilder.append(charArrays[j])
            j++
        }
    } else {
        while (j < max_index && charArrays[j + 1].isDigit()) {
            stringBuilder.append(charArrays[j + 1])
            j++
        }
    }
    return stringBuilder.toString().toInt()
}

