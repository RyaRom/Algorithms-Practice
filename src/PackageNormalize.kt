import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun main() {
    val root = File("src")
    for (packageDir in root.listFiles()!!) {
        if (packageDir.isDirectory) {
            val packageName = packageDir.name.replaceFirstChar { it.lowercase() }
            val newPack = File(root, packageName)
            println(newPack.path)
            val tempName = "src/temp${Math.random()}"
            runGitCommandWithRuntime("git mv --force ${packageDir.path} $tempName")
            runGitCommandWithRuntime("git mv --force $tempName ${newPack.path}")
            packageDir.renameTo(newPack)
        }
    }
}
fun runGitCommandWithRuntime(command: String): String {
    val runtime = Runtime.getRuntime()
    val process = runtime.exec(command)
    val result = StringBuilder()

    BufferedReader(InputStreamReader(process.inputStream)).use { reader ->
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            result.append(line).append("\n")
        }
    }

    process.waitFor()
    return result.toString()
}