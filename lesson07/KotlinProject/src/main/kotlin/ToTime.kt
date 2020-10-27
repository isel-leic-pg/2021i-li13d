// fun timeToSeconds(h: Int, m: Int, s: Int) : Int {
//   return h*60*60 + m*60 + s
// }

fun timeToSeconds(h: Int, m: Int, s: Int) : Int = h*60*60 + m*60 + s


/**
 * Values of this class represent a time unit with hours, minutes and seconds
 */
data class Time(val h: Int, val m: Int, val s: Int)


fun main() {

  val totalSeconds = readInt("Seconds")

  /*
  val h = totalSeconds / (60 * 60)

  val m = (totalSeconds % (60 * 60)) / 60

  val s = totalSeconds % 60
  */

  val time = Time(totalSeconds / (60 * 60), (totalSeconds % (60 * 60)) / 60, totalSeconds % 60)

  println("Time is ${time.h}h:${time.m}m:${time.s}s")
}

