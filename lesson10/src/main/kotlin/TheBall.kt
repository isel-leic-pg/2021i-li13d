import pt.isel.canvas.*

data class Point(val x: Int, val y: Int)

data class Velocity(val dx: Int, val dy: Int)

data class Ball(val center: Point, val radius: Int, val velocity: Velocity, val color: Int)

fun createBall(x: Int, y: Int, radius: Int, dx: Int, dy: Int, color: Int): Ball {
    val center = Point(x, y)
    val velocity = Velocity(dx, dy)
    return Ball(center, radius, velocity, color)
}


fun drawBall(ball: Ball, canvas: Canvas) : Unit {
    canvas.drawCircle(ball.center.x, ball.center.y, ball.radius, ball.color)
}

fun main() {
    val WIDTH = 600
    val HEIGHT = 400
    val RADIUS = 25

    onStart {
        val cv = Canvas(WIDTH, HEIGHT)

        var ball = createBall(WIDTH/2, HEIGHT/2, RADIUS,12, 12, RED)
        drawBall(ball, cv)

        cv.onTimeProgress(50) {
            cv.erase()
            val newX = ball.center.x + ball.velocity.dx
            val newY = ball.center.y + ball.velocity.dy


            val newDx = if(newX < RADIUS ) -1
                             else
                               if(newX > WIDTH-RADIUS) -1
                               else 1
            val newDy = if(newY < RADIUS ) -1
                    else
                        if(newY > HEIGHT-RADIUS) -1
                        else 1

            ball = createBall(newX, newY, ball.radius,ball.velocity.dx * newDx , ball.velocity.dy * newDy, ball.color)
            drawBall(ball, cv)
        }

        cv.onMouseDown {


        }

        cv.onKeyPressed { ke ->
        }
    }

    onFinish {
    }
}