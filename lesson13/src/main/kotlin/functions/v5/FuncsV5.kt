// Programa que realiza a soma, a subtração e a multiplicação
// de 2 valores inteiros introduzidos pelo utilizador para cada operação.
package isel.pg.functions.v5

import readInt


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


fun xpto() : (Int, Int) -> Int {
    val ret:(Int, Int) ->Int = { a, b -> a+b }
    return ret
}

fun xpto1() : (Int, Int) -> Int = { a, b -> a+b }