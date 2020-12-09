
import pt.isel.canvas.*
import kotlin.random.Random


val WIDTH = 600
val HEIGHT = 400
val RADIUS = 25
val WIDTH_ARKANOID = 90
val HEIGHT_ARKANOID = 25

data class Position(val x: Int, val y: Int)
data class Size(val width: Int, val height: Int)
data class Velocity(val dx: Int, val dy: Int)
data class Ball(val center: Position, val radius: Int, val velocity: Velocity, val color: Int)
data class Arkanoid(val position: Position, val size: Size, val color: Int = RED)



fun main() {
    onStart {
        var ball: Ball? = null
        var arkanoid = createArkanoid(WIDTH / 2 - WIDTH_ARKANOID/2, HEIGHT-10-HEIGHT_ARKANOID)
        val cv = Canvas(WIDTH, HEIGHT)

        cv.drawGame(ball, arkanoid)

        cv.onTimeProgress(50) {
            ball = ball?.move()
            cv.drawGame(ball, arkanoid)
        }

        cv.onMouseDown { mouse ->
//            val oldBall = ball
//            ball = if(oldBall != null) createBall(oldBall, x = mouse.x, y = mouse.y) else createBall()
            ball = if(ball != null) createBall(ball, x = mouse.x, y = mouse.y) else createBall()
        }

        cv.onMouseMove {
            arkanoid = createArkanoid(it.x - WIDTH_ARKANOID/2, arkanoid.position.y)
        }

        cv.onKeyPressed { ke: KeyEvent ->
            if(ball != null) {
                ball = newBallDependingOnKeyPressed(ball!!, ke.code, ke.char)
            }
        }
    }

    onFinish {
    }
}

private fun Canvas.drawGame(ball: Ball?, arkanoid: Arkanoid) {
    this.erase()

//    if(ball != null) {
//        ball.drawBall(this)
//    }

    ball?.drawBall(this)
    this.drawArkanoid(arkanoid)

}

fun createArkanoid(x: Int, y: Int, width: Int = WIDTH_ARKANOID, height: Int = HEIGHT_ARKANOID, color: Int = RED): Arkanoid = Arkanoid(Position(x, y), Size(width, height), color)


/**
 * Creates a new Ball
 *
 * @param ball The previous ball that serves as the basis for the new ball creation
 * @param x the new x ball position. Defaults ball.position
 *
 * @return the new ball
 */
fun createBall(ball: Ball, x: Int = ball.center.x, y: Int = ball.center.y, radius: Int = ball.radius, dx: Int = ball.velocity.dx, dy: Int = ball.velocity.dy, color: Int = ball.color): Ball? =
        createBall(x, y, radius, dx, dy, color)

/**
 *
 */
fun createBall(x: Int = WIDTH / 2, y: Int = HEIGHT / 2, radius: Int = RADIUS, dx: Int = 12, dy: Int = 12, color: Int = RED): Ball {
    val center = Position(x, y)
    val velocity = Velocity(dx, dy)
    return Ball(center, radius, velocity, color)
}


fun createBall(ball: Ball?, x: Int, y): Ball {

}





val colors = listOf(RED, YELLOW, GREEN)

fun randomColor(): Int = colors[Random.nextInt(0, colors.size)]



fun Ball.drawBall(canvas: Canvas) : Unit {
    canvas.drawCircle(this.center.x, this.center.y, this.radius, this.color)
}

fun Canvas.drawArkanoid(arkanoid: Arkanoid) {
    this.drawRect(arkanoid.position.x, arkanoid.position.y, arkanoid.size.width, arkanoid.size.height, arkanoid.color)
}


//fun plus(position: Position, velocity: Velocity) : Position = Position(position.x + velocity.dx, position.y + velocity.dy)

operator fun Position.plus(velocity: Velocity) : Position = Position(this.x + velocity.dx, this.y + velocity.dy)

fun newVelocityDetectingCollision(position: Position, velocity: Velocity) : Velocity {
    val newDx = if (position.x < RADIUS) -1
    else
        if (position.x > WIDTH - RADIUS) -1
        else 1
    val newDy = if (position.y < RADIUS) -1
    else
        if (position.y > HEIGHT - RADIUS) -1
        else 1

    return Velocity(velocity.dx * newDx, velocity.dy * newDy)
}

fun Ball.move() : Ball {
    val newPosition: Position = this.center + this.velocity
    val newVelocity = newVelocityDetectingCollision(newPosition, this.velocity)
    return createBall(newPosition.x, newPosition.y, this.radius, newVelocity.dx, newVelocity.dy, this.color)
}

fun newBallDependingOnKeyPressed(ball: Ball, code: Int, char: Char): Ball? =
        when (code) {
            LEFT_CODE -> createBall(ball, RADIUS, HEIGHT / 2)
            RIGHT_CODE -> createBall(ball, WIDTH - RADIUS, HEIGHT / 2)
            UP_CODE -> createBall(ball, WIDTH / 2, RADIUS)
            DOWN_CODE -> createBall(ball, WIDTH / 2, HEIGHT - RADIUS)

            else ->
                when (char) {
                    'c' -> createBall(ball, color = randomColor())
                    'r' -> createBall(ball, WIDTH / 2, HEIGHT / 2)
                    else -> ball
                }
        }


