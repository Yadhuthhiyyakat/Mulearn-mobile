import kotlin.math.sqrt
fun isPerfectNumber(number: Int): Boolean {
    if (number <= 1) return false
    var sumOfDivisors = 1 
    val limit = sqrt(number.toDouble()).toInt()
    for (i in 2..limit) 
    {
        if (number % i == 0)
        {
            sumOfDivisors += i
            val quotient = number / i
          if (i != quotient) 
            {
                sumOfDivisors += quotient
            }
        }
    }
    return sumOfDivisors == number
}

fun main() {
    val limit = 10000 
    
    println("Searching for perfect numbers up to $limit:\n")
    for (num in 1..limit) {
        if (isPerfectNumber(num)) {
            println("$num is a perfect number.")
        }
    }
    
    println("\n(The first four perfect numbers are 6, 28, 496, and 8128.)")
}
