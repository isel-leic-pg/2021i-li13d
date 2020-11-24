// Programa que realiza a soma, a subtração e a multiplicação
// de 2 valores inteiros introduzidos pelo utilizador para cada operação.
package isel.pg.functions.v1


import readInt

// Inicio da versão 1 ------------------------------------------

fun doAddition() {
    val a = readInt("A")
    val b = readInt("B")
    println("$a + $b = ${a + b}")
}

fun doSubtraction() {
    val a = readInt("A")
    val b = readInt("B")
    println("$a - $b = ${a - b}")
}

fun doMultiplication() {
    val a = readInt("A")
    val b = readInt("B")
    println("$a x $b = ${a * b}")
}

fun main() {
    doAddition()
    doSubtraction()
    doMultiplication()
}
//Fim da versão 1

