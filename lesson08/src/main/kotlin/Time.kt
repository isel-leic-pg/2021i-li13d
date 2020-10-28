fun timeToSeconds(time: Time) : Int = time.h*60*60 + time.m*60 + time.s

fun secondsToTime(seconds: Int) : Time = Time(seconds / (60 * 60), (seconds % (60 * 60)) / 60, seconds % 60)

fun Int.toTime() : Time = Time(this / (60 * 60), (this % (60 * 60)) / 60, this % 60)


/**
 * Values of this class represent a time unit with hours, minutes and seconds
 */
data class Time(val h: Int, val m: Int, val s: Int)
