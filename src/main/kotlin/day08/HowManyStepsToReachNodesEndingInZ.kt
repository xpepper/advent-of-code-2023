package day08

private val puzzleInput = """
    LR
    
    11A = (11B, XXX)
    11B = (XXX, 11Z)
    11Z = (11B, XXX)
    22A = (22B, XXX)
    22B = (22C, 22C)
    22C = (22Z, 22Z)
    22Z = (22B, 22B)
    XXX = (XXX, XXX)    
""".trimIndent()

fun main() {
    val inputLines = puzzleInput.split("\n")
    val turningInstructions = inputLines.first().trim()
    val nodeMap = inputLines.subList(2, inputLines.size)
        .asSequence()
        .map(String::trim)
        .map { it.split("=") }
        .associate { (node, nextNodes) -> node.trim() to nextNodes.trim() }
    var currentNodes = nodeMap.keys.filter { it.endsWith("A") }
    var steps = 0
    do {
//        if (steps % 1_000 == 0) print(".")
        val turnInstruction = turningInstructions[steps % turningInstructions.length]
        currentNodes = currentNodes.map { currentNode ->
            nodeMap[currentNode]?.removePrefix("(")?.removeSuffix(")")?.split(",")
                ?: throw InvalidNodeMap(nodeMap[currentNode])
        }.map {
            when (turnInstruction) {
                'R' -> it[1].trim()
                'L' -> it[0].trim()
                else -> throw InvalidNodeMap(it.joinToString(","))
            }
        }
        steps++
        println(currentNodes)
    } while (currentNodes.any { !it.endsWith("Z") })
    println(steps)
}
