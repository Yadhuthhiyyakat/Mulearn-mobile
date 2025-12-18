// Define the chromatic scale as a reference
val CHROMATIC_SCALE = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")

class MusicalTool(val root: String) {

    // Step patterns for different scales
    private val majorScalePattern = listOf(2, 2, 1, 2, 2, 2, 1)
    private val minorScalePattern = listOf(2, 1, 2, 2, 1, 2, 2)

    fun generateScale(pattern: List<Int>): List<String> {
        val scale = mutableListOf<String>()
        var currentIndex = CHROMATIC_SCALE.indexOf(root)

        if (currentIndex == -1) return listOf("Invalid Note")

        scale.add(CHROMATIC_SCALE[currentIndex])
        
        // Calculate each subsequent note based on the pattern
        for (step in pattern) {
            currentIndex = (currentIndex + step) % CHROMATIC_SCALE.size
            scale.add(CHROMATIC_SCALE[currentIndex])
        }
        return scale
    }

    fun getMajorChord(scale: List<String>): List<String> {
        // A basic triad uses the 1st, 3rd, and 5th notes of the scale
        return listOf(scale[0], scale[2], scale[4])
    }
}

fun main() {
    val myTool = MusicalTool("G")
    val gMajorScale = myTool.generateScale(listOf(2, 2, 1, 2, 2, 2, 1))
    val gMajorChord = myTool.getMajorChord(gMajorScale)

    println("G Major Scale: $gMajorScale")
    println("G Major Triad: $gMajorChord")
}