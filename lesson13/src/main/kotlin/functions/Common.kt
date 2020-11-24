//fun readInt(quest:String) :Int {
//    print("$quest? ")
//    return readLine()!!.trim().toInt()
//}


// - Para facilitar o DEBUG, gerar valores inteiros aleatórios
// - Evitar a repetição das funções do...
const val DEBUG = true

fun readInt(quest:String) :Int {
    print("$quest? ")
    return if (DEBUG) {
        val v = (1..10).random()
        println(v)
        v
    } else
        readLine()!!.trim().toInt()
}
