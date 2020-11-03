import pt.isel.canvas.*



fun main() {
    val WIDTH = 600
    val HEIGHT = 400
    val RADIUS = 25

    onStart {
        val cv = Canvas(WIDTH, HEIGHT)
        val deltaX = 5
        var directionX = -1
        var x = WIDTH/2
        var color = RED

        cv.drawCircle(x, HEIGHT/2, RADIUS, color)

        cv.onTimeProgress(50) {
            cv.erase()
            x += deltaX*directionX //x = x + delta
//            direction = if( x < RADIUS ) 1
//                        else
//                            if(x > WIDTH-RADIUS) -1
//                            else direction
            directionX *= if( x < RADIUS ) -1
                         else
                            if(x > WIDTH-RADIUS) -1
                            else 1
            cv.drawCircle(x, HEIGHT/2, RADIUS, color)
        }

        cv.onMouseDown {
            x = WIDTH / 2
        }

        cv.onKeyPressed { ke ->
            color = if(ke.char != 'c') color
                    else (0..0xFFFFFF).random()
        }
    }

    onFinish {
    }
}