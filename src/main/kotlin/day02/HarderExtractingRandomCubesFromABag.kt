package day02


// For each game, find the minimum set of cubes that must have been present.
// What is the sum of the power of these sets?
fun main() {
    val sum = gameRecords.map { gameRecord ->
        gameRecord.substringAfterLast(":").split(";").map { sample -> countCubesByColor(sample) }
    }
        .map { gameStats ->
            gameStats.flatMap { it.entries }
                .groupBy({ it.key }, { it.value })
                .mapValues { (_, values) -> values.maxOrNull()!! }
        }
        .map { it.values }
        .sumOf { it.reduce { acc, i -> acc * i } }

    println(sum)
}
