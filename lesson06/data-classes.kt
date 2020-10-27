data class Student(
  val name: String, 
  val number: Int
)

fun main() {
  val student1: Student = Student("Luis Falcão", 17118)
  println(student1.name)
  println(student1.number)
}


