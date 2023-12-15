package day09

fun main() {
    val input = inputData.split("\n").asSequence()
        .map { inputLine -> inputLine.trim().split(" ").map { it.trim().toInt() } }

    val result = input.map { sequence: List<Int> ->
        generateSequence(sequence) { seq ->
            seq.windowed(2) { it[1] - it[0] }.takeIf { it.any { it != 0 } }
        }.toList().let { seqList ->
            seqList.indices.reversed().fold(0) { acc, each -> seqList[each].first() - acc }
        }
    }.sum()

    println(result)
}
