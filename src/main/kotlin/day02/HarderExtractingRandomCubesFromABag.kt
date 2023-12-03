package day02


// For each game, find the minimum set of cubes that must have been present.
// What is the sum of the power of these sets?
fun main() {
    val games = gameRecords.map { gameRecord ->
        gameRecord.substringAfterLast(":").split(";").map { sample -> countCubesByColor(sample) }
    }
    val sum = games.map { gameStats ->
        fewestNumberOfCubesOfEachColor(gameStats)
    }
        .map { it.values }
        .sumOf { it.reduce { acc, eachValue -> acc * eachValue } }

    println(sum)
}

private fun fewestNumberOfCubesOfEachColor(gameStats: List<Map<CubeColor, Int>>) =
    gameStats.flatMap { it.entries }
        .groupBy({ it.key }, { it.value })
        .mapValues { (_, values) -> values.max() }
