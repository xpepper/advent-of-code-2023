package day09

fun main() {
    val input = inputData.split("\n").asSequence()
        .map { inputLine -> inputLine.trim().split(" ").map { it.trim().toInt() } }

    val result = input.map { sequence ->
        generateSequence(sequence) { seq ->
            seq.windowed(2) { it[1] - it[0] }.takeIf { it.any { it != 0 } }
        }.toList().let { seqList ->
            var acc = 0
            for (i in seqList.indices.reversed()) {
                acc = seqList[i].first() - acc
            }
            acc
        }
    }.sum()

    println(result)
}
