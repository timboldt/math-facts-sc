package mathfacts

import mathfacts.OpType._

class QuestionGenerator(val opType: OpType, val size: Int, val learnedQuestions: Set[Question]) {
  private def allQuestions: Set[Question] = (for {
    i <- 0 to size
    j <- 0 to (if (opType == Minus) { i } else { size})
  } yield Question(opType, i, j)).toSet[Question]

  val questions: Set[Question] = allQuestions.diff(learnedQuestions)
}
