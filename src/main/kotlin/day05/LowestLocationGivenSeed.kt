package day05

data class ConversionMap(val destinationRangeStart: Long, val sourceRangeStart: Long, val rangeLength: Long)

fun mapper(conversionMaps: List<ConversionMap>, input: Long): Long =
    conversionMaps.find { input in it.sourceRangeStart until it.sourceRangeStart + it.rangeLength }
        ?.let { input - (it.sourceRangeStart - it.destinationRangeStart) }
        ?: input

private val seeds =
    "seeds: 1347397244 12212989 2916488878 1034516675 2821376423 8776260 2240804122 368941186 824872000 124877531 1597965637 36057332 4091290431 159289722 1875817275 106230212 998513229 159131132 2671581775 4213184"
        .split(":")[1].toLongs()


fun main() {
    val allMaps = listOf(
        seedToSoilMap,
        soilToFertilizerMap,
        fertilizerToWaterMap,
        waterToLightMap,
        lightToTemperatureMap,
        temperatureToHumidityMap,
        humidityToLocationMap
    )
    seeds.mapIndexed { index, seed ->
        index to allMaps.fold(seed) { acc: Long, conversionMaps -> mapper(conversionMaps, acc) }
    }
        .minBy { (_, location) -> location }
        .also { (index, location) ->
            println("Seed ${seeds[index]} has the minimum location: $location")
        }
}
