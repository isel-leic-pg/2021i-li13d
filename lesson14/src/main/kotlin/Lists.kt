fun main() {
    // Create lists
    var numbersList: List<Int> = listOf(1,2,3,4,5,6,7)
    var numbersList1: List<Int> = listOf(8,9,10)

    // Access list elements ans size
    val listElement:Int = numbersList[1] // numbersList.get(1)
    println(listElement)
    println(numbersList.size)

    // Create new lists with more elements
    numbersList = numbersList + 8
    println(numbersList)

    // Create new lists with less elements
    numbersList = numbersList - 4
    println(numbersList)

    // Iterate through the list
    numbersList.forEach( { element ->
        println(element)
    })

    numbersList.forEach {
        println(it)
    }

    // Filter list elements
    val oddNumbers: List<Int> = numbersList.filter { it % 2 == 1 }
    println(oddNumbers)

    val doubleValues = numbersList.map { it * 2 }
    println(doubleValues)

}