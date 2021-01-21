
fun createListInt1(from:Int, to:Int, delta:Int) :List<Int> {
    var res = emptyList<Int>()
    var elem = from
    while ( elem <= to ) {
        res = res + elem
        elem += delta
    }
    return res
}

fun createListInt2(from:Int, to:Int, delta:Int) :List<Int> {
    var res = emptyList<Int>()
    for ( elem in from..to step delta ) {
        res = res + elem
    }
    return res
}

fun createListInt3(from:Int, to:Int, delta:Int) = (from..to step delta).toList()

fun createListFloat1(from:Float, to:Float, delta:Float) :List<Float> {
    var res = emptyList<Float>()
    var elem = from
    while(elem <= to) {
        res = res + elem
        elem += delta
    }
    return res
}

fun createListFloat2(from:Float, to:Float, delta:Float) :List<Float> {
    val size :Int = ((to-from) / delta).toInt()
    return (0..size).map{ from + it * delta }
}

fun main() {
    //val lst = createListInt3(0,20,2)
    val lst = createListFloat2(10.5F, 20.0F, 0.3F)
    println(lst)
}