package day05

private val seeds: Sequence<LongRange> =
    "seeds: 1347397244 12212989 2916488878 1034516675 2821376423 8776260 2240804122 368941186 824872000 124877531 1597965637 36057332 4091290431 159289722 1875817275 106230212 998513229 159131132 2671581775 4213184"
        .split(":")[1].toLongs()
        .zipWithNext().filterIndexed { index, _ -> index % 2 == 0 }
        .map { (start, rangeSize) -> start..start + rangeSize }
        .asSequence()

fun main() {
    seeds.flatMap { seedRange: LongRange ->
        seedRange.asSequence().map {
            val seedToSoil = mapper(seedToSoilMap, it)
            val soilToFertilizer = mapper(soilToFertilizerMap, seedToSoil)
            val fertilizerToWater = mapper(fertilizerToWaterMap, soilToFertilizer)
            val waterToLight = mapper(waterToLightMap, fertilizerToWater)
            val lightToTemperature = mapper(lightToTemperatureMap, waterToLight)
            val temperatureToHumidity = mapper(temperatureToHumidityMap, lightToTemperature)
            val humidityToLocation = mapper(humidityToLocationMap, temperatureToHumidity)
            humidityToLocation
        }
    }
        .min()
        .also { println("Minimum location: $it") }
}
