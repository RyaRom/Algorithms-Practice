import java.io.File

fun main() {
    val root = File("C:\\Users\\locadm\\Algorithms-Practice\\src")
    for (packageDir in root.listFiles()!!) {
        if (packageDir.isDirectory) {
            val packageName = packageDir.name.replaceFirstChar { it.lowercase() }
            val newPack = File(root, packageName)
            println(newPack.absolutePath)
            packageDir.renameTo(newPack)
        }
    }
}