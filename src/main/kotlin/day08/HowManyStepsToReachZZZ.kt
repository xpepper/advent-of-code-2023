package day08

private val puzzleInput = """
LLR

AAA = (BBB, BBB)
BBB = (AAA, ZZZ)
ZZZ = (ZZZ, ZZZ)
""".trimIndent()

fun main() {
    val inputLines = puzzleInput.split("\n")
    val turningInstructions = inputLines.first().trim()
    val startingNode = inputLines.subList(2,3).map(String::trim).map { it.split("=") }.first().first().trim()
        .also(::println)
    val nodeMap = inputLines.subList(2, inputLines.size)
        .asSequence()
        .map(String::trim)
        .map { it.split("=") }
        .associate { (node, nextNodes) -> node.trim() to nextNodes.trim() }
    var currentNode = startingNode
    var i = 0
    var steps = 0
    do {
        steps++
        println("current node is $currentNode")
        val turnInstruction = turningInstructions[i]
        if (turnInstruction == 'R')
            currentNode = nodeMap[currentNode]?.split(",")?.get(1)?.trim()?.replace(")", "") ?: TODO()
        if (turnInstruction == 'L')
            currentNode = nodeMap[currentNode]?.split(",")?.get(0)?.trim()?.replace("(", "") ?: TODO()

        i = (i + 1) % turningInstructions.length
    } while (currentNode != "ZZZ")
    println(steps)
}
