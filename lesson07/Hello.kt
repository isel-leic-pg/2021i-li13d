fun main() {
  println("Tell me your name: ")
  val name: String = readLine()!!
  println("Hello $name")


  println("And what is your age: ")
  val age: Byte = readLine()!!.trim().toByte()

  println("If you live twice of your current age, you'll live till ${age*2}")  
}