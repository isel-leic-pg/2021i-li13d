/**
 * Shows a message in console and asks to read an integer from standard input
 *
 * @message tge message to show in console
 * @return returns the integer value read from standard input
 */
fun readInt(message: String) : Int {
  println("$message:")
  val number = readLine()!!.toInt()
  return number
}


