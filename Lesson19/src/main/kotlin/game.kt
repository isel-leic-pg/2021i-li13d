import pt.isel.canvas.Canvas
import pt.isel.canvas.WHITE

/**
 * Represents the game status.
 *
 * Aggregates the falling piece ([moving]) and the blocks already fixed ([fixedBlocks]).
 */
data class Tetris(val moving:Piece, val fixedBlocks:List<Block>, val finish:Boolean=false)

/**
 * Draw the game.
 * @param g Status of game to draw
 */
fun Canvas.drawTetris(g:Tetris) {
    erase()
    drawPiece(g.moving)
    g.fixedBlocks.forEach { drawBlock(it) }
    if (g.finish)
        drawText(0,height/2,"END", WHITE,64)
}

/**
 * Try to move the falling block and check if it is fixed.
 * @receiver The original game
 * @param dx Horizontal offset to move
 * @param dy Vertical offset to move
 * @return The resulting game status
 */
fun Tetris.move(dx:Int, dy:Int) :Tetris? {
    if (finish) return null
    val piece = moving.move(dx, dy, fixedBlocks)
    return when {
        piece==null             -> null
        piece.toFix( fixedBlocks )    -> fixPiece(piece)
        else                -> Tetris( piece, fixedBlocks)
    }
}

/**
 * Fix a block and check if it forms a complete line.
 * Remove the complete line and drop the above lines.
 *
 * @receiver The original game
 * @param p block to fix
 * @return The resulting game status
 */
fun Tetris.fixPiece(p:Piece) :Tetris {
    var f = fixedBlocks + p.blks

    GRID_Y.forEach { y ->
        val line = f.filter { it.y==y }
        if (line.size == GRID_WIDTH)
            f = (f - line).map{ if(it.y<y) Block(it.x,it.y+1,it.color) else it  }
    }

    val newPiece = newPiece()
    return Tetris( newPiece, f , newPiece.toFix( f ) )
}

fun Tetris.rotate():Tetris? {
    if (finish) return null
    val p = moving.rotate(fixedBlocks) ?: return null
    return Tetris(p,fixedBlocks,finish)
}

