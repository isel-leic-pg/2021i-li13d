// Programa que realiza a soma, a subtração e a multiplicação
// de 2 valores inteiros introduzidos pelo utilizador para cada operação.
package isel.pg.functions.v2

import readInt


//Inicio da versão 2:  -----------------------------------------

fun add(a:Int, b:Int) :Int = a + b
fun sub(a:Int, b:Int) :Int = a - b
fun mult(a:Int, b:Int) = a * b


fun doOperation(operation:Char) {
    val a = readInt("A")
    val b = readInt("B")
    val res = when (operation) {
        '+' -> add(a,b)
        '-' -> sub(a, b)
        else -> mult(a,  b)  //Code smell
    }
    println("$a $operation $b = $res")
}

fun main() {
    doOperation('+')
    doOperation('-')
    doOperation('x')
}
