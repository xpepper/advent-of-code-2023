import java.nio.file.Files
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path

@ExperimentalPathApi
fun main() {
    val url = {}.javaClass.getResource("/calibration.txt")
    val path = Path(url.path)
    var counter = 0
    Files.newBufferedReader(path).use { reader ->
        reader.lines().forEach { line ->
            val firstDigit = line.find { it.isDigit() }?.toString() ?: ""
            val lastDigit = line.reversed().find { it.isDigit() }?.toString() ?: ""
            counter += (firstDigit + lastDigit).toInt()
        }
    }
    println(counter)
}
