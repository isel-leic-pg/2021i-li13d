// Programa que realiza a soma, a subtração e a multiplicação
// de 2 valores inteiros introduzidos pelo utilizador para cada operação.
package isel.pg.functions.v

import readInt


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

