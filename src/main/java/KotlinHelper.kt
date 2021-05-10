import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

@Throws(IOException::class)
fun writeToFile(text: String, targetFilePath: String) {
    val targetPath: Path = Paths.get(targetFilePath)
    val bytes: ByteArray = ("$text\n-------------\n").toByteArray()
    Files.write(targetPath, bytes, StandardOpenOption.CREATE, StandardOpenOption.APPEND)
}