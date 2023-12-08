package day05

fun String.toLongs() = trim().split(" ").map(String::toLong)

fun String.toConversionMaps() =
    lines().filterNot { it.isBlank() }.map(String::toLongs).map { ConversionMap(it[0], it[1], it[2]) }
