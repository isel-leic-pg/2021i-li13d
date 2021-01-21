import pt.isel.canvas.*

/**
 * Block information.
 *
 * Position ([x],[y]) and [color].
 * @property x Horizontal block position
 * @property y Vertical block position
 * @property color Background color of block
 */
data class Block(val x:Int, val y:Int, val color:Int)

/**
 * Side of each block in pixels.
 */
const val BLOCK_SIDE = 35

/**
 * Edge thickness of each block.
 * It must be an odd value.
 */
const val BORDER = 3

/**
 * Draws a bordered block.
 *
 * @receiver where to draw
 * @param b block to draw
 */
fun Canvas.drawBlock(b:Block) {
    val x = b.x*BLOCK_SIDE  // in pixels
    val y = b.y*BLOCK_SIDE  // in pixels
    drawRect(x, y, BLOCK_SIDE, BLOCK_SIDE, b.color)
    drawRect(x+BORDER/2, y+BORDER/2, BLOCK_SIDE-BORDER, BLOCK_SIDE-BORDER, 0xAAAAAA, BORDER)
}

/**
 * Moves the block by horizontal and vertical displacement.
 * @param dx Horizontal offset
 * @param dy Vertical offset
 * @return Moved block or null
 * @receiver Original block
 */
fun Block.move(dx:Int, dy:Int, f:List<Block>) :Block? {
    val b= Block(x + dx, y + dy, color)
    return if (b.valid(f)) b else null
}

fun Block.valid(f:List<Block>) = x in GRID_X && y in GRID_Y && f.all { it.x!=x || it.y!=y }

/**
 * Checks whether the block should be fixed.
 * Hit the bottom or hit another piece already fixed.
 * @receiver Block to check
 * @param f Blocks already fixed
 * @return true if should be fixed
 */
fun Block.toFix(f :List<Block>) = (y == GRID_Y.last || f.any { it.y == y+1 && it.x == x })

/**
 * Possible block colors.
 */
val COLORS = listOf(BLUE, RED, YELLOW, CYAN, MAGENTA, GREEN, 0xFF8000)

/**
 * Creates a new block centered at the top with a random color.
 * @return the new block
 */
fun newBlock() = Block(GRID_WIDTH/2, 0, COLORS.random())

