// fun timeToSeconds(h: Int, m: Int, s: Int) : Int {
//   return h*60*60 + m*60 + s
// }



fun main() {

  val startTime = readInt("Seconds start time")
  val endTime = readInt("Seconds end time")

  val difTime = endTime - startTime


  //val time = secondsToTime(difTime)
  val time = difTime.toTime()

  println("Time is ${time.h}h:${time.m}m:${time.s}s")
}

