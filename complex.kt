import kotlin.math.*

data class Complex(val real: Double, val imag: Double) {

    // Basic Operations
    operator fun plus(other: Complex) = Complex(real + other.real, imag + other.imag)
    operator fun minus(other: Complex) = Complex(real - other.real, imag - other.imag)
    
    operator fun times(other: Complex): Complex {
        val r = this.real * other.real - this.imag * other.imag
        val i = this.real * other.imag + this.imag * other.real
        return Complex(r, i)
    }

    // 1. Conjugate: Flip the sign of the imaginary part
    fun conjugate() = Complex(real, -imag)

    // 2. Absolute Value (Magnitude): sqrt(a^2 + b^2)
    fun abs() = sqrt(real.pow(2) + imag.pow(2))

    // 3. Exponent (e^z): e^(a + bi) = e^a * (cos(b) + i sin(b))
    fun exp(): Complex {
        val expReal = exp(real)
        return Complex(expReal * cos(imag), expReal * sin(imag))
    }

    override fun toString(): String {
        return if (imag >= 0) "$real + ${imag}i" else "$real - ${-imag}i"
    }
}

fun main() {
    val z1 = Complex(3.0, 4.0)
    val z2 = Complex(1.0, 2.0)

    println("z1: $z1")
    println("z2: $z2")
    println("---")
    println("Addition: ${z1 + z2}")
    println("Multiplication: ${z1 * z2}")
    println("Conjugate of z1: ${z1.conjugate()}")
    println("Absolute value of z1: ${z1.abs()}")
    println("Exponent of z1 (e^z1): ${z1.exp()}")
}