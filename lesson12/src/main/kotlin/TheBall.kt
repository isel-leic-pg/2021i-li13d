import pt.isel.canvas.*
import kotlin.random.Random


val WIDTH = 600
val HEIGHT = 400
val RADIUS = 25

data class Position(val x: Int, val y: Int)

data class Velocity(val dx: Int, val dy: Int)

data class Ball(val center: Position, val radius: Int, val velocity: Velocity, val color: Int)


fun main() {

    onStart {
        var ball = createBall(WIDTH / 2, HEIGHT / 2, RADIUS, 12, 12, RED)
        val cv = Canvas(WIDTH, HEIGHT)

        //drawBall(ball, cv)
        cv.drawBall(ball)

        cv.onTimeProgress(50) {
            //ball = moveBall(ball)
            ball = ball.move()

            //drawBall(ball, cv)
            cv.drawBall(ball)
        }

        cv.onMouseDown { mouse ->
            ball = createBall(ball, x = mouse.x, y = mouse.y)
        }

        cv.onKeyPressed { ke: KeyEvent ->
            ball = newBallDependingOnKeyPressed(ball, ke.code, ke.char)
        }
    }

    onFinish {
    }
}


/**
 * Creates a new Ball
 *
 * @param ball The previous ball that serves as the basis for the new ball creation
 * @param x the new x ball position. Defaults ball.position
 *
 * @return the new ball
 */
fun createBall(ball: Ball, x: Int = ball.center.x, y: Int = ball.center.y, radius: Int = ball.radius, dx: Int = ball.velocity.dx, dy: Int = ball.velocity.dy, color: Int = ball.color): Ball =
        createBall(x, y, radius, dx, dy, color)


/**
 *
 */
fun createBall(x: Int, y: Int, radius: Int, dx: Int, dy: Int, color: Int): Ball {
    val center = Position(x, y)
    val velocity = Velocity(dx, dy)
    return Ball(center, radius, velocity, color)
}

fun randomColor(): Int = Random.nextInt(0, 0xFFFFFF)


//fun drawBall(ball: Ball, canvas: Canvas): Unit {
//    canvas.erase()
//    canvas.drawCircle(ball.center.x, ball.center.y, ball.radius, ball.color)
//}

fun Canvas.drawBall(ball: Ball) {
    this.erase()
    this.drawCircle(ball.center.x, ball.center.y, ball.radius, ball.color)
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

//fun moveBall(ball: Ball) : Ball {
//    val newPosition: Position =
//            //add(ball.center, ball.velocity)
//            // ball.center.plus(ball.velocity)
//            ball.center + ball.velocity
//    val newVelocity = newVelocityDetectingCollision(newPosition, ball.velocity)
//    return createBall(newPosition.x, newPosition.y, ball.radius, newVelocity.dx, newVelocity.dy, ball.color)
//}

fun Ball.move() : Ball {
    val newPosition: Position = this.center + this.velocity
    val newVelocity = newVelocityDetectingCollision(newPosition, this.velocity)
    return createBall(newPosition.x, newPosition.y, this.radius, newVelocity.dx, newVelocity.dy, this.color)
}



fun newBallDependingOnKeyPressed(ball: Ball, code: Int, char: Char): Ball =
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
