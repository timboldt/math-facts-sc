package mathfacts

object OpType extends Enumeration {
  type OpType = Value
  val Plus, Minus, Times = Value
}
import OpType._

class Question(val opType: OpType, val value1: Int, val value2: Int) {
  def answer: Int = opType match {
    case Plus => value1 + value2
    case Minus => value1 - value2
    case Times => value1 * value2
  }

  def op: Char = opType match {
    case Plus => '+'
    case Minus => '-'
    case Times => 'x'
  }
}
