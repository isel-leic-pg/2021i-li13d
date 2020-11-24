// Programa que realiza a soma, a subtração e a multiplicação
// de 2 valores inteiros introduzidos pelo utilizador para cada operação.
package isel.pg.functions.v3

import readInt

//Inicio da versão 3:  -----------------------------------------
// - A função readInt(:String):Int permanece igual nesta versão e nas seguintes
// - A função doOperation() tem uma função como parâmetro adicional
// - As funções de cada operação são globais

typealias DoubleIntToInt = (Int, Int) -> Int

fun doOperation(operation:Char, calc: DoubleIntToInt) : Unit {
    val a = readInt("A")
    val b = readInt("B")

    val res = calc(a, b)

    println("$a $operation $b = $res")
}

fun add(a:Int, b:Int) :Int = a + b
fun sub(a:Int, b:Int) :Int = a - b
fun mult(a:Int, b:Int) = a * b

fun mult3(a:Int, b:Int, c: Int) = a * b * c

fun main() {
    doOperation('+', ::add)
    doOperation('-', ::sub)
    doOperation('x', ::mult)
    //doOperation('x', ::mult3)
}

//Fim da versão 3