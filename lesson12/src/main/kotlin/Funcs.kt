// Programa que realiza a soma, a subtração e a multiplicação
// de 2 valores inteiros introduzidos pelo utilizador para cada operação.

// Inicio da versão 1 ------------------------------------------
//fun readInt(quest:String) :Int {
//    print("$quest? ")
//    return readLine()!!.trim().toInt()
//}
//
//fun doAddition() {
//    val a = readInt("A")
//    val b = readInt("B")
//    println("$a + $b = ${a + b}")
//}
//
//fun doSubtraction() {
//    val a = readInt("A")
//    val b = readInt("B")
//    println("$a - $b = ${a - b}")
//}
//
//fun doMultiplication() {
//    val a = readInt("A")
//    val b = readInt("B")
//    println("$a x $b = ${a * b}")
//}
//
//fun main() {
//    doAddition()
//    doSubtraction()
//    doMultiplication()
//}
//Fim da versão 1

/*
//Inicio da versão 2:  -----------------------------------------
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

fun doOperation(operation:Char) {
    val a = readInt("A")
    val b = readInt("B")
    val res = when (operation) {
        '+' -> a + b
        '-' -> a - b
        else -> a * b  //Code smell
    }
    println("$a $operation $b = $res")
}

fun main() {
    doOperation('+')
    doOperation('-')
    doOperation('x')
}
//Fim da versão 2

//Inicio da versão 3:  -----------------------------------------
// - A função readInt(:String):Int permanece igual nesta versão e nas seguintes
// - A função doOperation() tem uma função como parâmetro adicional
// - As funções de cada operação são globais

fun doOperation(operation:Char, calc:(Int,Int)->Int) {
    val a = readInt("A")
    val b = readInt("B")
    val res = calc(a,b)
    println("$a $operation $b = $res")
}

fun add(a:Int, b:Int) :Int {
    return a + b
}
fun sub(a:Int, b:Int) :Int { return a - b }
fun mult(a:Int, b:Int) = a * b

fun main() {
    doOperation('+', ::add)
    doOperation('-', ::sub)
    doOperation('x', ::mult)
}
//Fim da versão 3

//Inicio da versão 4:  -----------------------------------------
// - As funções de cada operação são locais ou são valores com expressões lambda

fun doOperation(operation:Char, calc:(Int,Int)->Int) {
    val a = readInt("A")
    val b = readInt("B")
    println("$a $operation $b = ${calc(a,b)}")
}

fun main() {
    fun add(a:Int, b:Int) = a + b
    val sub : (Int,Int)->Int = { a,b -> a - b }
    val mult = { a:Int, b:Int -> a * b }

    doOperation('+', ::add)
    doOperation('-', sub)
    doOperation('x', calc = mult)
}
//Fim da versão 4

//Inicio da versão 5:  -----------------------------------------
// - typealias para o tipo da função
// - As funções de cada operação são argumentos (expressões lambda) em cada chamada
typealias OperFx = (Int,Int)->Int

fun doOperation(operation:Char, calc:OperFx) {
    val a = readInt("A")
    val b = readInt("B")
    println("$a $operation $b = ${calc(a,b)}")
}

fun main() {
    doOperation('+', { a:Int, b:Int -> a + b } )
    doOperation('-', { a,b -> a - b } )
    doOperation('x') { a,b -> a * b }
}
//Fim da versão 5
*/