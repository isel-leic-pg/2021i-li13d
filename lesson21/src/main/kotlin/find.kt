
fun find(list: List<Float>, value: Float): Int? {
    var idx = 0

    while(idx < list.size) {
        if(value == list[idx]) return idx
        ++idx
    }
    return null
}


fun find1(list: List<Float>, value: Float): Int? {
    for(idx in list.indices) {
        if (value == list[idx]) return idx
    }
    return null
}

fun find2(list: List<Float>, value: Float): Int? {
    repeat(list.size) { idx ->
        if(list[idx] == value) return idx
    }
    return null
}


fun find3(list: List<Float>, value: Float): Int? {
    val idx = list.indexOf(value)
    return if(idx == -1) null else idx
}

fun main() {
    val lst = createListFloat2(15.0F,20.0F,0.5F).shuffled()
    println(lst)
    val existingIdx = find(lst,16.5F)
    println(existingIdx)

    val nonExistingIdx = find(lst,16.6F)
    println(nonExistingIdx)
}