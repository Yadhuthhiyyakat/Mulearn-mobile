import java.security.SecureRandom

fun main() {
    println("=== Password Security Checker ===")
    
    // 1. Prompt the user
    print("Enter a password to check: ")
    
    // 2. Read the input from the terminal
    val userInput = readln()

    // 3. Validate the input using your class
    val strength = PasswordUtility.validate(userInput)

    // 4. Show the result
    println("---------------------------------")
    if (strength != null) {
        println("Result: Your password is [$strength]")
    } else {
        println("Result: Your password is [TOO WEAK]")
        println("Tip: Use at least 8 characters and include digits.")
    }
    println("---------------------------------")
}

class PasswordUtility {
    enum class Strength { LOW, INTERMEDIATE, STRONG }

    companion object {
        private val random = SecureRandom()
        private const val SYMBOLS = "!@#$%^&*()-_=+[]{}|;:,.<>?"

        // ... generate logic remains the same ...
        fun generate(strength: Strength): String {
            val lower = "abcdefghijklmnopqrstuvwxyz"
            val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            val digits = "0123456789"
            return when (strength) {
                Strength.LOW -> generateRandom(8, lower + digits)
                Strength.INTERMEDIATE -> generateRandom(12, lower + upper + digits)
                Strength.STRONG -> generateRandom(16, lower + upper + digits + SYMBOLS)
            }
        }

        fun validate(password: String): Strength? {
            val hasLower = password.any { it.isLowerCase() }
            val hasUpper = password.any { it.isUpperCase() }
            val hasDigit = password.any { it.isDigit() }
            val hasSymbol = password.any { it in SYMBOLS }
            val length = password.length

            return when {
                length >= 16 && hasLower && hasUpper && hasDigit && hasSymbol -> Strength.STRONG
                length >= 12 && hasLower && hasUpper && hasDigit -> Strength.INTERMEDIATE
                length >= 8 && (hasLower || hasUpper) && hasDigit -> Strength.LOW
                else -> null
            }
        }

        private fun generateRandom(length: Int, characterSet: String): String {
            return (1..length)
                .map { characterSet[random.nextInt(characterSet.length)] }
                .joinToString("")
        }
    }
}