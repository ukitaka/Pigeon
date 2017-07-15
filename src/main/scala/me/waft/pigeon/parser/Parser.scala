package me.waft.pigeon.parser

import fastparse.WhitespaceApi
import fastparse.all._
import me.waft.pigeon.ast.{Operator, Term}

object Parser {

  private[this] val White = WhitespaceApi.Wrapper {
    NoTrace(" ".rep)
  }

  import White._

  val trueP: Parser[Term] = P("true").map(_ => Term.True)
  val falseP: Parser[Term] = P("false").map(_ => Term.False)
  def boolP: Parser[Term] = trueP | falseP

  val ifP: Parser[Term] = P("if" ~ termP ~ "then" ~ termP ~ "else" ~ termP).map(Term.If.tupled)

  object Number {
    // number
    val intP: Parser[Term] = P(CharIn('0' to '9').rep(1).!.map(_.toInt).map(Term.Int))

    // operator
    private val plusP: Parser[Operator] = P("+").map(_ => Operator.Plus)
    private val minusP: Parser[Operator] = P("-").map(_ => Operator.Minus)
    private val timesP: Parser[Operator] = P("*").map(_ => Operator.Times)
    private val divP: Parser[Operator] = P("/").map(_ => Operator.Div)
    private val opP: Parser[Operator] = plusP | minusP | timesP | divP

    private def numberFactor: Parser[Term] = intP | numberOpsP | parenNumberOpsP
    val numberOpsP: Parser[Term] = P(numberFactor ~ opP ~ numberFactor).map(Term.Ops.tupled)
    val parenNumberOpsP: Parser[Term] = P("(" ~ numberOpsP ~ ")")

    val numberExprP: Parser[Term] = numberOpsP | parenNumberOpsP | intP
  }

  val termP: Parser[Term] = boolP | Number.numberExprP | ifP
}