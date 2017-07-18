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

    private val addP: Parser[Operator] = P("+").map(_ => Operator.Add)
    private val subP: Parser[Operator] = P("-").map(_ => Operator.Sub)
    private val mulP: Parser[Operator] = P("*").map(_ => Operator.Mul)
    private val divP: Parser[Operator] = P("/").map(_ => Operator.Div)

    private val addSubP: Parser[Operator] = addP | subP
    private val mulDivP: Parser[Operator] = mulP | divP

    private def mulDivLeftExprP: Parser[Term] = parenExprP | intP
    private def mulDivExprP: Parser[Term] = P(mulDivLeftExprP ~ mulDivP ~ exprP).map(Term.Ops.tupled)
    private def addSubLeftExprP: Parser[Term] = parenExprP | mulDivExprP | intP
    private def addSubExprP: Parser[Term] = P(addSubLeftExprP ~ addSubP ~ exprP).map(Term.Ops.tupled)

    private def parenExprP: Parser[Term] = P("(" ~ exprP ~ ")")
    def exprP: Parser[Term] = addSubExprP | mulDivExprP | parenExprP | intP
  }

  val termP: Parser[Term] = boolP | Number.exprP | ifP
}
