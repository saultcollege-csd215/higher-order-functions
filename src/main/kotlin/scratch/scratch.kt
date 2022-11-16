package scratch

// These functions exhibit the "implicit argument in function name" code smell
fun multiplyByTwo(x: Int) = x * 2
fun multiplyByTwelve(x: Int) = x * 12
fun multiplyByPi(x: Int) = x * Math.PI
fun multiplyByE(x: Int) = x * Math.E

// This function is a more general implementation of the above functions
fun multiplyBy(x: Int, y: Int) = x * y

val m = ::multiplyByTwo  // A function reference
val isEmpty = String::isEmpty  // A reference to the isEmpty() method of the String class


fun hof(f: () -> Unit) {
    f()
}

fun main() {
    var x = 2

    hof { println(x) }

    x = 3

    hof { println(x) }

}

