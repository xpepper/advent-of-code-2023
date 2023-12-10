package day06

private val puzzleInput = """
    Time:      7  15   30
    Distance:  9  40  200
""".trimIndent()

fun main() {
    val (times, distances) = puzzleInput.split("\n")
        .map { it.split(":")[1].trim().split(Regex("\\s+")).map(String::toInt) }
    times.zip(distances).map { (raceTime, raceRecord) ->
        var counter = 0
        for (chargeTime in 0..raceTime) {
            if (((raceTime - chargeTime) * chargeTime) > raceRecord) {
                counter++
            }
        }
        println("Record beaten $counter times")
        counter
    }.product().also(::println)
}

private fun Iterable<Int>.product(): Int = fold(1) { acc, i -> acc * i }

