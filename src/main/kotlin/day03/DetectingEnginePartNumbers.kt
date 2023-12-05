package day03

private const val max_index = 139

fun main() {
    // a 140x140 matrix
    val charArrays = engineSchemata.map { it.toCharArray() }

    val numbers = mutableListOf<Int>()
    for (i in 0..max_index) {
        for (j in 0..max_index) {
            val e = charArrays[i][j]
            if (!e.isDigit() && e != '.') { // symbol found

                // adjacent in the previous row
                if (i > 0 && charArrays[i - 1][j].isDigit()) {
                    // up
                    detectNumberIn(charArrays[i - 1], j).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }
                if (i > 0 && j > 0 && charArrays[i - 1][j - 1].isDigit()) {
                    // up-left
                    detectNumberIn(charArrays[i - 1], j - 1).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }
                if (i > 0 && j < max_index && charArrays[i - 1][j + 1].isDigit()) {
                    // up-right
                    detectNumberIn(charArrays[i - 1], j + 1).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }

                // adjacent in the same row
                if (j > 0 && charArrays[i][j - 1].isDigit()) {
                    // previous
                    detectNumberIn(charArrays[i], j - 1).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }
                if (j < max_index && charArrays[i][j + 1].isDigit()) {
                    // following
                    detectNumberIn(charArrays[i], j + 1).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }

                // adjacent in the following row
                if (i < max_index && charArrays[i + 1][j].isDigit()) {
                    // down
                    detectNumberIn(charArrays[i + 1], j).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }
                if (i < max_index && j > 0 && charArrays[i + 1][j - 1].isDigit()) {
                    // down-left
                    detectNumberIn(charArrays[i + 1], j - 1).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }
                if (i < max_index && j < max_index && charArrays[i + 1][j + 1].isDigit()) {
                    // down-right
                    detectNumberIn(charArrays[i + 1], j + 1).let {
                        if (numbers.lastOrNull() != it) numbers.add(it)
                    }
                }
            }
        }
    }
    println(numbers.sum())
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

