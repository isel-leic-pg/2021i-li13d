

fun main() {
    val vals = createListOfInt(1, 9, 2)
    println(vals)
    val vals1 = createListOfInt(1, 10, 2)
    println(vals1)

    val vals2 = createListOfFloat(11.1F, 15.1F, 0.5F).shuffled()
    println(vals2)

    val idx1: Int? = find(vals2, 14.1F)
    println(idx1)

    val idx2: Int? = find(vals2, 14.2F)
    println(idx2)
}


fun find(values: List<Float>, elem: Float) : Int? {
    //val idx = list.indexOf(elem)
    //return if(idx == -1) null else idx

//    var idx = 0
//    while(idx < values.size) {
//        if(values[idx] == elem) return idx
//    }
//

    for(idx in values.indices) {
        if(values[idx] == elem) return idx
    }

    return null
}



fun createListOfInt(from: Int, to: Int, delta: Int) : List<Int> {
    val range: IntProgression = from..to step delta

    // Using toList from IntProgression
    //return range.toList()


    // Using a for loop and range
//    var resultList = emptyList<Int>()
//    for(elem in range) {
//        resultList = resultList + elem
//    }
//    return resultList

    var resultList = emptyList<Int>()
    var elem = from
    while(elem < to) {
        resultList = resultList + elem
        elem += delta //elem = elem + delta
    }
    return resultList
}

fun createListOfFloat(from: Float, to: Float, delta: Float) : List<Float> {
    val size = ((to-from) / delta).toInt()
    //return (0..size).map { elem -> from + elem * delta }


    // Using the for loop
//    var resultList = emptyList<Float>()
//    for(elem in 0..size) {
//        val value = from + elem * delta
//        resultList = resultList + value
//    }
//
//    return resultList

    // using the while loop

    var resultList = emptyList<Float>()
    var elem = 0

    while(elem <= size) {
        val value = from + elem * delta
        resultList = resultList + value
        ++elem
    }

    return resultList


}