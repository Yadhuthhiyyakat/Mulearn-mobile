fun main() {
    val positions = (0..4).toList()
    
    // Helper to get all permutations of a list
    fun <T> List<T>.permutations(): Sequence<List<T>> = sequence {
        if (size <= 1) yield(this@permutations)
        else {
            val element = get(0)
            (subList(1, size)).permutations().forEach { sub ->
                for (i in 0..sub.size) {
                    val next = sub.toMutableList()
                    next.add(i, element)
                    yield(next)
                }
            }
        }
    }

    val nationalities = listOf("Brit", "Swede", "Dane", "Norwegian", "German").permutations()
    val colors = listOf("Red", "Green", "White", "Yellow", "Blue").permutations()
    val beverages = listOf("Tea", "Coffee", "Milk", "Beer", "Water").permutations()
    val cigars = listOf("Pall Mall", "Dunhill", "Blends", "Blue Masters", "Prince").permutations()
    val pets = listOf("Dogs", "Birds", "Cats", "Horses", "Zebra").permutations()

    for (nat in nationalities) {
        if (nat[0] != "Norwegian") continue // Rule 9

        for (col in colors) {
            if (col.indexOf("Red") != nat.indexOf("Brit")) continue // Rule 1
            if (col.indexOf("White") != col.indexOf("Green") + 1) continue // Rule 4
            if (col[1] != "Blue") continue // Rule 14 (Norwegian is at 0, Blue must be at 1)

            for (bev in beverages) {
                if (bev[2] != "Milk") continue // Rule 8
                if (bev.indexOf("Tea") != nat.indexOf("Dane")) continue // Rule 3
                if (bev.indexOf("Coffee") != col.indexOf("Green")) continue // Rule 5

                for (cig in cigars) {
                    if (cig.indexOf("Dunhill") != col.indexOf("Yellow")) continue // Rule 7
                    if (cig.indexOf("Blue Masters") != bev.indexOf("Beer")) continue // Rule 12
                    if (cig.indexOf("Prince") != nat.indexOf("German")) continue // Rule 13
                    if (Math.abs(cig.indexOf("Blends") - bev.indexOf("Water")) != 1) continue // Rule 15

                    for (pet in pets) {
                        if (pet.indexOf("Dogs") != nat.indexOf("Swede")) continue // Rule 2
                        if (pet.indexOf("Birds") != cig.indexOf("Pall Mall")) continue // Rule 6
                        if (Math.abs(cig.indexOf("Blends") - pet.indexOf("Cats")) != 1) continue // Rule 10
                        if (Math.abs(pet.indexOf("Horses") - cig.indexOf("Dunhill")) != 1) continue // Rule 11

                        // If we reach here, we found the solution!
                        println("House | Nationality | Color  | Beverage | Cigar        | Pet")
                        println("--------------------------------------------------------------")
                        for (i in 0..4) {
                            println("${i + 1}     | ${nat[i].padEnd(11)} | ${col[i].padEnd(6)} | ${bev[i].padEnd(8)} | ${cig[i].padEnd(12)} | ${pet[i]}")
                        }
                        return
                    }
                }
            }
        }
    }
}