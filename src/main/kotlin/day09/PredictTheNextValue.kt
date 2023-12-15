package day09

val inputData = """
    0 3 6 9 12 15
    1 3 6 10 15 21
    10 13 16 21 30 45
""".trimIndent()

fun main() {
    val input = inputData.split("\n").asSequence()
        .map { inputLine -> inputLine.trim().split(" ").map { it.trim().toInt() } }

    val result = input.map { sequence ->
        generateSequence(sequence) { seq ->
            seq.windowed(2) { it[1] - it[0] }.takeIf { it.any { it != 0 } }
        }.toList().let { seqList ->
            var acc = 0
            for (i in seqList.indices.reversed()) {
                acc += seqList[i].last()
            }
            acc
        }
    }.sum()

    println(result)
}
