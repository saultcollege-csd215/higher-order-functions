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

fun updateArrayItems(array: Array<String>) {
    for (i in array.indices) {
        array[i] = array[i].toUpperCase()
    }
}