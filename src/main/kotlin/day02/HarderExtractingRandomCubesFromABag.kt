package day02


// For each game, find the minimum set of cubes that must have been present.
// What is the sum of the power of these sets?
fun main() {
    val games = gameRecords.map { gameRecord ->
        gameRecord.substringAfterLast(":").split(";").map { sample -> countCubesByColor(sample) }
    }
    val sum = games.map { gameStats ->
        gameStats.flatMap { it.entries }
            .groupBy({ it.key }, { it.value })
            .mapValues { (_, values) -> values.max() }
    }
        .map { it.values }
        .sumOf { it.reduce { acc, i -> acc * i } }

    println(sum)
}
