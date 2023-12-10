package day06

private val puzzleInput = """
    Time:      7  15   30
    Distance:  9  40  200
""".trimIndent()

fun main() {
    val (times, distances) = puzzleInput.split("\n")
        .map { it.split(":")[1].trim().split(Regex("\\s+")).map(String::toInt) }
    times.zip(distances).map { (raceTime, raceRecord) ->
        (0..raceTime).fold(0) { counter, chargeTime ->
            if (((raceTime - chargeTime) * chargeTime) > raceRecord) {
                counter + 1
            } else counter
        }.also { println("Record beaten $it times") }
    }.product().also(::println)
}

private fun Iterable<Int>.product(): Int = fold(1) { acc, i -> acc * i }

