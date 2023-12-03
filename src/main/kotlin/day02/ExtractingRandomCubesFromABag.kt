package day02

import day02.CubeColor.Blue
import day02.CubeColor.Green
import day02.CubeColor.Red

private val bagConfiguration = mapOf(Red to 12, Green to 13, Blue to 14)

// which games would have been possible if the bag contained only
// 12 red cubes, 13 green cubes, and 14 blue cubes?
fun main() {
    val games = gameRecords.mapIndexed { index, gameRecord ->
        val game = gameRecord.substringAfterLast(":").split(";").map { sample -> countCubesByColor(sample) }
        index + 1 to game
    }
    val validGamesSum = games.filter { (_, gameStats) -> gameStats.all { it.isValidGame() } }
        .sumOf { (gameNumber, _) -> gameNumber }

    println(validGamesSum)
}

private fun Map<CubeColor, Int>.isValidGame() =
    getOrDefault(Red, 0) <= bagConfiguration.getOrDefault(Red, 0) &&
            getOrDefault(Green, 0) <= bagConfiguration.getOrDefault(Green, 0) &&
            getOrDefault(Blue, 0) <= bagConfiguration.getOrDefault(Blue, 0)

