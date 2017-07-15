package me.waft.pigeon

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
    Parser.intP.parse("0").get.value should(be(Int(0)))
    Parser.intP.parse("1").get.value should(be(Int(1)))
    Parser.intP.parse("2").get.value should(be(Int(2)))
    Parser.intP.parse("9").get.value should(be(Int(9)))
    Parser.intP.parse("10").get.value should(be(Int(10)))
    Parser.intP.parse("10281").get.value should(be(Int(10281)))
  }
}
