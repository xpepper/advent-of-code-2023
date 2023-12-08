package day05

data class ConversionMap(val destinationRangeStart: Long, val sourceRangeStart: Long, val rangeLength: Long)

fun mapper(conversionMaps: List<ConversionMap>, input: Long): Long =
    conversionMaps.find { input in it.sourceRangeStart until it.sourceRangeStart + it.rangeLength }
        ?.let { input - (it.sourceRangeStart - it.destinationRangeStart) }
        ?: input

fun main() {
    seeds.mapIndexed { index, seed ->
        val seedToSoil = mapper(seedToSoilMap, seed)
        val soilToFertilizer = mapper(soilToFertilizerMap, seedToSoil)
        val fertilizerToWater = mapper(fertilizerToWaterMap, soilToFertilizer)
        val waterToLight = mapper(waterToLightMap, fertilizerToWater)
        val lightToTemperature = mapper(lightToTemperatureMap, waterToLight)
        val temperatureToHumidity = mapper(temperatureToHumidityMap, lightToTemperature)
        val humidityToLocation = mapper(humidityToLocationMap, temperatureToHumidity)
        println("$seed => $humidityToLocation")
        index to humidityToLocation
    }
        .minBy { (_, location) -> location }
        .also { (index, location) ->
            println("Seed ${seeds[index]} has the minimum location: $location")
        }
}
