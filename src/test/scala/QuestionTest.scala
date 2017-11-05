import org.scalatest._
import mathfacts._

class QuestionTest extends FunSpec with Matchers {
  describe("when using questions") {
    it("standard math should work") {
      new Question(OpType.Plus, 22, 6).answer should equal (28)
      new Question(OpType.Minus, 11, 2).answer should equal (9)
      new Question(OpType.Times, 16, 4).answer should equal (64)
    }
    it("operators should be correct") {
      new Question(OpType.Plus, 22, 6).op should equal ('+')
      new Question(OpType.Minus, 11, 2).op should equal ('-')
      new Question(OpType.Times, 16, 4).op should equal ('x')
    }
  }
}
