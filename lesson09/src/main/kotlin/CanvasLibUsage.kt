import pt.isel.canvas.*


fun main() {
    val WIDTH = 600
    val HEIGHT = 400
    val RADIUS = 25


    println("Begin")
    onStart {
        val cv = Canvas(WIDTH, HEIGHT)
        cv.drawCircle(WIDTH/2, HEIGHT/2, RADIUS, 0xCA2C92)
        cv.drawLine(0, 0, WIDTH-1, HEIGHT-1, 0x7F0000)
        cv.drawLine(0, HEIGHT-1, WIDTH-1, 0, RED)

        val rectHeight = (50+RADIUS)*2
        val rectWidth = (100 + RADIUS) * 2

        val rectX = WIDTH/2-RADIUS-100
        val rectY = HEIGHT/2-RADIUS-50

        cv.drawRect(rectX, rectY, rectWidth, rectHeight, BLUE, 3)

        cv.drawCircle( rectX - 10 - rectHeight / 2, HEIGHT/2, rectHeight / 2, BLUE)
        cv.drawCircle( rectX - 10 - rectHeight / 2 + 10, HEIGHT/2 + 10, rectHeight / 2, RED)
        cv.drawCircle( rectX + rectWidth + 10 + rectHeight / 2, HEIGHT/2, rectHeight / 2, RED)


        cv.drawArc( rectX + rectWidth / 2, rectY-10, rectWidth / 2, 0, 180,  YELLOW)


        cv.drawText( WIDTH/2-45, rectY+ rectHeight + 25, "Benfica", RED, 30)



    }
    onFinish {
        println("Finish")
    }

    println("End")
}