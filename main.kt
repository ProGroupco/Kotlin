import kotlinx.coroutines.*

/**
 * A "Kothin" (Complex/Dense) demonstration of Kotlin's core power:
 * Multiplatform-ready logic, Null Safety, Interoperability, and Coroutines.
 */

// 1. Data Class with Null Safety
data class Developer(val name: String, val favoriteLanguage: String?)

// 2. Sealed Interface for Platform Versatility
sealed interface Platform {
    object Android : Platform
    object Backend : Platform
    class Multiplatform(val targets: List<String>) : Platform
}

class KotlinShowcase {

    // 3. Type Inference & Interoperability-friendly list
    private val devList = listOf(
        Developer("JetBrains", "Kotlin"),
        Developer("Google", "Kotlin"),
        Developer("Legacy Coder", null)
    )

    // 4. Higher-Order Function & Functional Programming
    fun filterSafeDevs() = devList.filter { it.favoriteLanguage != null }

    // 5. Coroutines for Asynchronous Programming (Safety & Efficiency)
    suspend fun promoteKotlin() = coroutineScope {
        launch {
            val status = Platform.Android
            // 6. When expression (Smart Casting)
            val message = when (status) {
                is Platform.Android -> "Google's preferred language since 2019."
                is Platform.Backend -> "Spring Boot & Ktor ready."
                is Platform.Multiplatform -> "iOS, Desktop, and Web support."
            }
            println("Kotlin Status: $message")
        }
    }
}

// 7. Entry point using modern syntax
fun main() = runBlocking {
    val showcase = KotlinShowcase()
    
    // Null safety check using safe call operator ?. and Elvis operator ?:
    showcase.filterSafeDevs().forEach { 
        println("${it.name} loves ${it.favoriteLanguage ?: "Unknown"}") 
    }

    showcase.promoteKotlin()
}
