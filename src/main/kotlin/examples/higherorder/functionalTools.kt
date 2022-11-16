package examples.higherorder

fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2 until n) {
        if (n % i == 0) return false
    }
    return true
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

    // Map examples
    val doubled = numbers.map { it * 2 }      // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40]
    val squared = numbers.map { it * it }     // [1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400]
    val isEven = numbers.map { it % 2 == 0 }  // [false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true]

    // Filter examples
    val evens = numbers.filter { it % 2 == 0 }   // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
    val odds = numbers.filter { it % 2 != 0 }    // [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
    val primes = numbers.filter { isPrime(it) }  // [2, 3, 5, 7, 11, 13, 17, 19]

    // Fold examples
    val sum = numbers.fold(0) { total, next -> total + next }                       // 210
    val product = numbers.fold(1) { total, next -> total * next }                   // 2432902008176640000
    val max = numbers.fold(0) { total, next -> if (next > total) next else total }  // 20

    // FlatMap examples
    data class Person(val name: String, val luckyNumbers: List<Int>)
    val people = listOf(
        Person("Alice", listOf(1, 2, 3)),
        Person("Bob", listOf(4, 5, 6)),
        Person("Carol", listOf(7, 8, 9))
    )
    val alice = people.find { it.name == "Alice" }  // Person(name=Alice, luckyNumbers=[1, 2, 3])
    val allLuckyNumbers = people.flatMap { it.luckyNumbers } // [1, 2, 3, 4, 5, 6, 7, 8, 9]

    // Chained examples
    val doubledEvens = numbers.filter { it % 2 == 0 }.map { it * 2 }  // [4, 8, 12, 16, 20, 24, 28, 32, 36, 40]
    val sumOfLuckyNumbers = people.flatMap { it.luckyNumbers }.fold(0) { total, next -> total + next }  // 45
    val largestEvenLuckyNumber = people.flatMap { it.luckyNumbers }
                                        .filter { it % 2 == 0 }
                                        .fold(0) { total, next -> if (next > total) next else total }  // 8

    // All / Any examples
    val allEven = numbers.all { it % 2 == 0 }       // false
    val evensEven = evens.all { it % 2 == 0 }       // true
    val anyEven = numbers.any { it % 2 == 0 }       // true
    val any10 = numbers.any { it == 10 }            // true
    val any100 = numbers.any { it == 100 }          // false
    val allLessThan100 = numbers.all { it < 100 }   // true

}