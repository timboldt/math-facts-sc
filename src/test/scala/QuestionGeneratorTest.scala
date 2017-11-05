import org.scalatest._
import mathfacts._

class QuestionGeneratorTest extends FunSpec with Matchers with Inspectors {
  describe("when generating questions") {
    describe("with no previously-learned questions") {
      it("the number of questions should equal '(size+1)^2' (i.e. accounting for zero values)") {
        new QuestionGenerator(OpType.Plus, 20, Set.empty).questions.size should equal(21 * 21)
        new QuestionGenerator(OpType.Minus, 2, Set.empty).questions.size should equal(6) // No negative numbers.
        new QuestionGenerator(OpType.Times, 1, Set.empty).questions.size should equal(2 * 2)
        new QuestionGenerator(OpType.Plus, 0, Set.empty).questions.size should equal(1)
        new QuestionGenerator(OpType.Plus, -1, Set.empty).questions.size should equal(0)
        new QuestionGenerator(OpType.Plus, -99, Set.empty).questions.size should equal(0)
      }
      it("the generated values should have the requested op type") {
        assert(new QuestionGenerator(OpType.Plus, 20, Set.empty).questions.forall(_.opType == OpType.Plus))
        assert(new QuestionGenerator(OpType.Minus, 20, Set.empty).questions.forall(_.opType == OpType.Minus))
        assert(new QuestionGenerator(OpType.Times, 20, Set.empty).questions.forall(_.opType == OpType.Times))
      }
    }
    describe("when there are previously-learned questions") {
      it("should exclude those questions from the results") {
        val learned = Set(
          Question(OpType.Plus, 1, 2),
          Question(OpType.Plus, 3, 3),
        )
        new QuestionGenerator(OpType.Plus, 20, learned).questions.size should equal(21 * 21 - 2)
      }
      it("should not exclude questions where the op type doesn't match") {
        val learned = Set(
          Question(OpType.Minus, 1, 2),
          Question(OpType.Plus, 3, 3),
        )
        new QuestionGenerator(OpType.Plus, 20, learned).questions.size should equal(21 * 21 - 1)
      }
      it("should not exclude questions that didn't have values within the generation range") {
        val learned = Set(
          Question(OpType.Plus, 1, 1),
          Question(OpType.Plus, 1, 2),
          Question(OpType.Plus, 3, 3),
        )
        new QuestionGenerator(OpType.Plus, 1, learned).questions.size should equal(2 * 2 - 1)
      }
    }
  }
}