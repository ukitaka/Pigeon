package me.waft.pigeon

import me.waft.pigeon.ast.Operator
import me.waft.pigeon.ast.Term._
import me.waft.pigeon.parser.Parser
import org.scalatest.{FlatSpec, Matchers}

class ParserSpec extends FlatSpec with Matchers {

  "parser" should "parse bool" in {
    Parser.trueP.parse("true").get.value should(be(True))
    Parser.falseP.parse("false").get.value should(be(False))
    Parser.boolP.parse("false").get.value should(be(False))
    Parser.boolP.parse("true").get.value should(be(True))
  }

  "parser" should "parse if" in {
    Parser.ifP.parse("if true then true else false").get.value should(be(If(True, True, False)))
  }

  "parser" should "parse nat" in {
    Parser.Number.intP.parse("0").get.value should(be(Int(0)))
    Parser.Number.intP.parse("1").get.value should(be(Int(1)))
    Parser.Number.intP.parse("2").get.value should(be(Int(2)))
    Parser.Number.intP.parse("9").get.value should(be(Int(9)))
    Parser.Number.intP.parse("10").get.value should(be(Int(10)))
    Parser.Number.intP.parse("10281").get.value should(be(Int(10281)))
  }

  "parser" should "parse plus" in {
    Parser.Number.exprP.parse("0 + 1").get.value should (be(Ops(Int(0), Operator.Add, Int(1))))
    Parser.Number.exprP.parse("( 0 + 1 )").get.value should (be(Ops(Int(0), Operator.Add, Int(1))))
    Parser.Number.exprP.parse("(1 + 2) + 3").get.value should (be(Ops(Ops(Int(1), Operator.Add, Int(2)), Operator.Add, Int(3))))
    Parser.Number.exprP.parse("1 + 2 + 3").get.value should (be(Ops(Int(1), Operator.Add, Ops(Int(2), Operator.Add, Int(3)))))
    Parser.Number.exprP.parse("1 + (2 + 3)").get.value should (be(Ops(Int(1), Operator.Add, Ops(Int(2), Operator.Add, Int(3)))))
    Parser.Number.exprP.parse("(1 + 2 + 3)").get.value should (be(Ops(Int(1), Operator.Add, Ops(Int(2), Operator.Add, Int(3)))))
    Parser.Number.exprP.parse("1 * 2").get.value should (be(Ops(Int(1), Operator.Mul, Int(2))))
    Parser.Number.exprP.parse("(1 * 2)").get.value should (be(Ops(Int(1), Operator.Mul, Int(2))))
    Parser.Number.exprP.parse("1 * 2 * 3").get.value should (be(Ops(Int(1), Operator.Mul, Ops(Int(2), Operator.Mul, Int(3)))))
//    Parser.Number.exprP.parse("1 * 2").get.value should (be(Ops(Int(1), Operator.Add, Ops(Int(2), Operator.Add, Int(3)))))
  }
}
