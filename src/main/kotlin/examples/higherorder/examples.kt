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

    "abcdef".forEach(::println)         // Prints each letter on its own line
    listOf(1, 2, 3).forEach(::println)  // Prints each number on its own line

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
}

