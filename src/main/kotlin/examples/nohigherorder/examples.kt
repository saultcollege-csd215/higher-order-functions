package examples.nohigherorder

fun cook(s: String) = "Cooked $s"
fun eat(s: String) = "Ate $s"
fun wash(s: String) = "Washing $s"
fun dry(s: String) = "Drying $s"
fun putAway(s: String) = "Putting away $s"

// The functions below have the same overall structure:
// loop over a list of strings
// We can generalize this structure using a higher-order function
fun cookAndEatFoods(foods: List<String>) {
    for (food in foods) {
        cook(food)
        eat(food)
    }
}

fun cleanDishes(dishes: List<String>) {
    for ( d in dishes ) {
        wash(d)
        dry(d)
        putAway(d)
    }
}

fun doubleAll(numbers: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (n in numbers) {
        result.add(n * 2)
    }
    return result
}

fun befuddleAll(numbers: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (n in numbers) {
        result.add(n + 4 / (n*n) - 3)
    }
    return result
}

fun squareAll(numbers: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (n in numbers) {
        result.add(n * n)
    }
    return result
}

fun removeVowels(s: String): String {
    var result = ""
    for (c in s) {
        if (c !in "aeiouAEIOU") {
            result += c
        }
    }
    return result
}

fun removeNumbers(s: String): String {
    var result = ""
    for (c in s) {
        if (c !in "0123456789") {
            result += c
        }
    }
    return result
}

fun removeStuffOverE(s: String): String {
    var result = ""
    for (c in s) {
        if (c <= 'e') {
            result += c
        }
    }
    return result
}

fun countVowels(s: String): Int {
    var result = 0
    for (c in s) {
        if (c in "aeiouAEIOU") {
            result += 1
        }
    }
    return result
}

fun countNumbers(s: String): Int {
    var result = 0
    for (c in s) {
        if (c in "0123456789") {
            result += 1
        }
    }
    return result
}

fun countStuffOverE(s: String): Int {
    var result = 0
    for (c in s) {
        if (c > 'e') {
            result += 1
        }
    }
    return result
}
