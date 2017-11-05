package mathfacts

import mathfacts.OpType._

case class Question(opType: OpType, value1: Int, value2: Int) {
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
