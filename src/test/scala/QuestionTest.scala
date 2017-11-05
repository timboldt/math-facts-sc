import org.scalatest._
import mathfacts._

class QuestionTest extends FunSpec with Matchers {
  describe("when using questions") {
    it("standard math should work") {
      Question(OpType.Plus, 22, 6).answer should equal (28)
      Question(OpType.Minus, 11, 2).answer should equal (9)
      Question(OpType.Times, 16, 4).answer should equal (64)
    }
    it("operators should be correct") {
      Question(OpType.Plus, 22, 6).op should equal ('+')
      Question(OpType.Minus, 11, 2).op should equal ('-')
      Question(OpType.Times, 16, 4).op should equal ('x')
    }
  }
}
