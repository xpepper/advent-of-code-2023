import java.nio.file.Files
import java.util.stream.Stream
import kotlin.io.path.Path

fun streamFile(fileName: String, process: (Stream<String>) -> Unit) {
    val url = {}.javaClass.getResource(fileName)
    Files.newBufferedReader(Path(url.path)).use { reader ->
        process(reader.lines())
    }
}

