package mathfacts

object Main extends App {
  val q = new Question(OpType.Times, 12, 3)
  println(q.value1 + " " + q.op + " " + q.value2 + " = " + q.answer)
}