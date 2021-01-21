package enums

import pt.isel.canvas.BLUE
import pt.isel.canvas.CYAN
import pt.isel.canvas.YELLOW

enum class Tetromino(val color: Int) {
    J(BLUE),
    I(YELLOW),
    O(CYAN),
}

data class Piece(val kind: Tetromino)

enum class Direction(val dx: Int, val dy: Int) {
    LEFT(-1, 0),
    RIGHT(1, 0),
    UP(0, -1),
    DOWN(0, 1)
}

fun main() {
    val j: Tetromino = Tetromino.J
    val i: Tetromino = Tetromino.I
    val o: Tetromino = Tetromino.O

    println("1st")
    println(j.name)
    println(j.ordinal)
    println("2nd")
    println(i.name)
    println(i.ordinal)
    println("3rd")
    println(o.name)
    println(o.ordinal)


    println("---- All values from Tetromino -------")
    Tetromino.values().forEach { tetromino ->
        println(tetromino.name)
        println(tetromino.ordinal)
    }

    println("---- All values from Direction ------")
    Direction.values().forEach { dir ->
        println(dir.name)
        println(dir.ordinal)
    }

    println(directionString(Direction.LEFT))
    println(directionString(Direction.DOWN))
}


fun directionString(direction: Direction) : String {
    return when(direction) {
        Direction.LEFT  ->  "Moving Left"
        Direction.RIGHT ->  "Moving Right"
        Direction.UP    ->  "Moving Up"
        Direction.DOWN  ->  "Moving Down"
    }
}




