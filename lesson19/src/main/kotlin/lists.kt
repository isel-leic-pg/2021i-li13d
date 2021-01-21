

fun main() {

    // Map always return a list of the same size but with a possible different type
    // List<T>.map ( (T) -> R ) -> List<R>

    val numbers: List<Int> = listOf(1,2,3,4,5)
    val squareNumbers: List<Int>    = numbers.map { n -> n * n}              // Int -> Int
    val doubleNumbers: List<Double> = numbers.map { n -> n * 1.0 }          // Int -> Double
    val stringNumbers: List<String> = numbers.map { n -> n.toString() }     // Int -> String


    // Filter always returns a list of the same type, but its size is between 0 and the original list size
    // List<T>.filter ( (T) -> Boolean) -> List<T>

    val evenNumbers: List<Int>  = numbers.filter { n -> n % 2 == 0 }
    println(evenNumbers)
    val oddNumbers: List<Int>  = numbers - evenNumbers //numbers.filter { n -> n % 2 == 1 }
    println(oddNumbers)
    val rangeNumbers: List<Int>  = numbers.filter { n -> n in 2..4 }


}