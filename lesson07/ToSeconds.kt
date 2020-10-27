/* 
fun readInt(message: String) : Int {
  println("$message:")
  val number = readLine()!!.toInt()
  return number
}
*/

// fun timeToSeconds(h: Int, m: Int, s: Int) : Int {
//   return h*60*60 + m*60 + s
// }

fun timeToSeconds(h: Int, m: Int, s: Int) : Int = h*60*60 + m*60 + s


fun main() {
  /* 
  println("Hours:")
  val h = readLine()!!.toInt()
  
  println("Minutes:")
  val m = readLine()!!.toInt()
  
  println("Seconds:")
  val s = readLine()!!.toInt()
  */

  val h = readInt("Hours"); 
  
  val m = readInt("Minutes")
  
  val s = readInt("Seconds")

  val durationInSeconds = timeToSeconds(h, m, s)

  println("Time in seconds is $durationInSeconds")
}

