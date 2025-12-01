fun isPangram(sentence: String): Boolean {
    // 1. Convert the sentence to lowercase to handle case-insensitivity.
    val lowerCaseSentence = sentence.lowercase() 

    // 2. Filter out only the alphabetical characters and store them in a Set.
    //    A Set only holds unique elements.
    val uniqueLetters = lowerCaseSentence
        .filter { it in 'a'..'z' }
        .toSet()

    // 3. Check if the size of the set is 26 (the number of letters in the English alphabet).
    return uniqueLetters.size == 26
}

// --- Example Usage ---

fun main() {
    val pangramSentence = "The quick brown fox jumps over the lazy dog" // Missing S!
    val pangramSentenceCorrected = "The quick brown fox jumps over the lazy dog." // Has all 26 letters

    println("\"$pangramSentence\" is a pangram: ${isPangram(pangramSentence)}")
    println("\"$pangramSentenceCorrected\" is a pangram: ${isPangram(pangramSentenceCorrected)}")
    println("\"Hello, World!\" is a pangram: ${isPangram("Hello, World!")}")
}