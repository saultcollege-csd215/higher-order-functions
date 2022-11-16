package examples.higherorder

fun logIt(s: String) = println(s)

// This function takes a function and calls it inside a try-catch block that logs errors
fun withLogging(f: () -> Unit) {
    try {
        f()
    } catch (e: Exception) {
        logIt("Exception: ${e.message}")
    }
}

// This function takes a function and returns a new function when called will call the original function with logging
fun makeLoggingFunction(f: () -> Unit): () -> Unit {
    // Here, we return a function that when called will call the original function and log any exceptions
//    return {
//        try {
//            f()
//        } catch (e: Exception) {
//            logIt("Exception: ${e.message}")
//        }
//    }

    // This does the same thing as the commented code above
    // (Here, we are using the withLogging function to wrap the given function with the try/catch block,
    // but we are wrapping it in a lambda expression which we then return.)
    return {
        withLogging(f)
    }

}


fun aFuncThatNeedsLogging() {
    println("Doing something")
    throw Exception("Something went wrong")
}

fun anotherFuncThatNeedsLogging(n: Int): Int {
    val r = n * 3

    if (n < 0) {
        throw Exception("n must be positive")
    }

    return r
}

fun main() {
    // Since aFuncThatNeedsLogging() takes no parameters, we can use a function reference
    withLogging(::aFuncThatNeedsLogging)

    // Since anotherFuncThatNeedsLogging() doesn't match the expected interface, we need to use a lambda expression
    // We can rely on closure to capture the value of n
    var n = -1
    withLogging {
        val x = anotherFuncThatNeedsLogging(n)
        println("x = $x")
    }

    // With makeLoggingFunction, we can build a new function out of an existing function...
    val aFuncWithLogging = makeLoggingFunction(::aFuncThatNeedsLogging)
    // and then use it wherever we need the original function's behavior plus logging
    aFuncWithLogging()

}