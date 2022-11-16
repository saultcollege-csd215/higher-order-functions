package examples.higherorder

fun cook(s: String) = println("Cooked $s")
fun eat(s: String) = println("Ate $s")
fun wash(s: String) = println("Washing $s")
fun dry(s: String) = println("Drying $s")
fun putAway(s: String) = println("Putting away $s")

// This function generalizes the 'loop over list of strings' structure
// used in both cookAndEatFoods and cleanDishes
// The parameter f allows the caller to specify what happens
// in the body of the loop
fun forEach(list: List<String>, f: (String) -> Unit) {
    for (item in list) {
        f(item)
    }
}

fun tryCatch(tryThis: () -> Unit, orCatch: (Exception) -> Unit) {
    try {
        tryThis()
    } catch (e: Exception) {
        orCatch(e)
    }
}

fun cookAndEat(food: String) {
    cook(food)
    eat(food)
}
fun cookAndEatFoods(foods: List<String>) {
    // Using a function reference
//     forEach(foods, ::cookAndEat)

    // Using an anonymous inline function
//    forEach(foods, fun(food: String) {
//        cook(food)
//        eat(food)
//    })

    // Using a lambda expression
//     forEach(foods, { food ->
//         cook(food)
//         eat(food)
//     })

    // Using a lambda expression with implicit parameter
//    forEach(foods, {
//        cook(it)
//        eat(it)
//    })

    // Using trailing lambda syntax
    forEach(foods) {
        cook(it)
        eat(it)
    }
}

fun cleanDish(dish: String) {
    wash(dish)
    dry(dish)
    putAway(dish)
}
fun cleanDishes(dishes: List<String>) {
    forEach(dishes, ::cleanDish)
}

fun main() {

    var clean = ::cleanDish     // A function reference
    var strPlus = String::plus  // A reference to a class method
    var objPlus = "abc"::plus   // A reference to an object method

//    "abcdef".forEach(::println)         // Prints each letter on its own line
//    listOf(1, 2, 3).forEach(::println)  // Prints each number on its own line

    // Basic types
    val a: Int
    val s: String
    val b: Boolean
    // Generic types
    val l: List<Int>
    val m: Map<String, Int>

    // Function types
    val f1: (Int) -> Int          // A function that accepts an Int and returns an Int
    val f2: (Int, Int) -> String  // A function that accepts two Ints and returns a String
    val f3: () -> Unit            // A function that accepts no arguments and returns nothing
    val f4: (String) -> Unit      // A function that accepts a String and returns nothing
    val f5: () -> String          // A function that accepts no arguments and returns a String
    val f6: (Int) -> (Int) -> Int // A function that accepts an Int and returns a function that accepts an Int and returns an Int
    val f7: ((Int) -> Int) -> Int // A function that accepts a function that accepts an Int and returns an Int and returns an Int


    println(countStuffOverE("abcdefg"))
}

fun doubleAll(numbers: List<Int>): List<Int> {
    // This line is the equivalent of the commented code below
    return numbers.map { it * 2 }
//    val result = mutableListOf<Int>()
//    for (n in numbers) {
//        result.add(n * 2)
//    }
//    return result
}

fun befuddleAll(numbers: List<Int>): List<Int> {
    // This line is the equivalent of the commented code below
    return numbers.map { it + 4 / (it*it) - 3 }
//    val result = mutableListOf<Int>()
//    for (n in numbers) {
//        result.add(n + 4 / (n*n) - 3)
//    }
//    return result
}

fun squareAll(numbers: List<Int>): List<Int> {
    // This line is the equivalent of the commented code below
    return numbers.map { it * it }
//    val result = mutableListOf<Int>()
//    for (n in numbers) {
//        result.add(n * n)
//    }
//    return result
}

fun removeVowels(s: String): String {
    // This line is the equivalent of the commented code below
    return s.filter { it !in "aeiouAEIOU" }
//    var result = ""
//    for (c in s) {
//        if (c !in "aeiouAEIOU") {
//            result += c
//        }
//    }
//    return result
}

fun removeNumbers(s: String): String {
    // This line is the equivalent of the commented code below
    return s.filter { it !in "0123456789"  }
//    var result = ""
//    for (c in s) {
//        if (c !in "0123456789") {
//            result += c
//        }
//    }
//    return result
}

fun removeStuffOverE(s: String): String {
    // This line is the equivalent of the commented code below
    return s.filter { it <= 'e' }
//    var result = ""
//    for (c in s) {
//        if (c <= 'e') {
//            result += c
//        }
//    }
//    return result
}

fun countVowels(s: String): Int {
    // This line is the equivalent of the commented code below
    return s.fold(0) { total, c -> if (c in "aeiouAEIOU") total + 1 else total }
//    var result = 0
//    for (c in s) {
//        if (c in "aeiouAEIOU") {
//            result += 1
//        }
//    }
//    return result
}

fun countNumbers(s: String): Int {
    // This line is the equivalent of the commented code below
    return s.fold(0) { total, c -> if (c in "0123456789") total + 1 else total }
//    var result = 0
//    for (c in s) {
//        if (c in "0123456789") {
//            result += 1
//        }
//    }
//    return result
}

fun countStuffOverE(s: String): Int {
    // This line is the equivalent of the commented code below
    return s.fold(0) { total, c -> if (c > 'e') total + 1 else total }

//    return foldStuff(s, 0) {
//        total, c -> if (c > 'e') total + 1 else total
//    }
//    var result = 0
//    for (c in s) {
//        if (c > 'e') {
//            result += 1
//        }
//    }
//    return result
}

// This is map in terms of fold
fun map(s: String, f: (Char) -> Char): String {
    return s.fold("") { result, c -> result + f(c) }
}

// This is filter in terms of fold
fun filter(s: String, f: (Char) -> Boolean): String {
    return s.fold("") { result, c -> if (f(c)) result + c else result }
}

//fun foldStuff(s: String, initial: Int, f: (Int, Char) -> Int): Int {
//    var result = initial
//    for (c in s) {
//        result = f(result, c)
//    }
//    return result
//}
