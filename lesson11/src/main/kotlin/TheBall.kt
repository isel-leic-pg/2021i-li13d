import pt.isel.canvas.*
import kotlin.random.Random

data class Point(val x: Int, val y: Int)

data class Velocity(val dx: Int, val dy: Int)

data class Ball(val center: Point, val radius: Int, val velocity: Velocity, val color: Int)

fun createBall(ball: Ball, x: Int = ball.center.x, y: Int = ball.center.y, radius: Int = ball.radius, dx: Int = ball.velocity.dx, dy: Int = ball.velocity.dy, color: Int = ball.color): Ball = createBall(x, y, radius, dx, dy, color)


fun createBall(x: Int, y: Int, radius: Int, dx: Int, dy: Int, color: Int): Ball {
    val center = Point(x, y)
    val velocity = Velocity(dx, dy)
    return Ball(center, radius, velocity, color)
}

fun randomColor(): Int = Random.nextInt(0, 0xFFFFFF)


fun drawBall(ball: Ball, canvas: Canvas): Unit {
    canvas.drawCircle(ball.center.x, ball.center.y, ball.radius, ball.color)
}

fun main() {
    val WIDTH = 600
    val HEIGHT = 400
    val RADIUS = 25

    onStart {
        val cv = Canvas(WIDTH, HEIGHT)

        var ball = createBall(WIDTH / 2, HEIGHT / 2, RADIUS, 12, 12, RED)
        drawBall(ball, cv)

        cv.onTimeProgress(50) {
            cv.erase()
            val newX = ball.center.x + ball.velocity.dx
            val newY = ball.center.y + ball.velocity.dy


            val newDx = if (newX < RADIUS) -1
            else
                if (newX > WIDTH - RADIUS) -1
                else 1
            val newDy = if (newY < RADIUS) -1
            else
                if (newY > HEIGHT - RADIUS) -1
                else 1

            ball = createBall(newX, newY, ball.radius, ball.velocity.dx * newDx, ball.velocity.dy * newDy, ball.color)
            drawBall(ball, cv)
        }

        cv.onMouseDown { mouse ->
            ball = createBall(ball, x = mouse.x, y = mouse.y)
        }

        cv.onKeyPressed { ke ->
            ball = when (ke.code) {
                LEFT_CODE -> createBall(ball, RADIUS, HEIGHT / 2)
                RIGHT_CODE -> createBall(ball, WIDTH - RADIUS, HEIGHT / 2)
                UP_CODE -> createBall(ball, WIDTH / 2, RADIUS)
                DOWN_CODE -> createBall(ball, WIDTH / 2, HEIGHT - RADIUS)

                else ->
                    when (ke.char) {
                        'c' -> createBall(ball, color = randomColor())
                        'r' -> createBall(ball, WIDTH / 2, HEIGHT / 2)
                        else -> ball
                    }
            }
        }
    }

    onFinish {
    }
}