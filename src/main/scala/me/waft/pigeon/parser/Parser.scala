package me.waft.pigeon.parser

import fastparse.WhitespaceApi
import fastparse.all._
import me.waft.pigeon.ast.Term

object Parser {

  private[this] val White = WhitespaceApi.Wrapper {
    NoTrace(" ".rep)
  }

  import White._

  val trueP: Parser[Term] = P("true").map(_ => Term.True)
  val falseP: Parser[Term] = P("false").map(_ => Term.False)
  def boolP: Parser[Term] = trueP | falseP

  val ifP: Parser[Term] = P("if" ~ termP ~ "then" ~ termP ~ "else" ~ termP).map(r => Term.If(r._1, r._2, r._3))

  private val zeroP: Parser[String] = P("0").!
  private val headDigitsP: Parser[String] = P(CharIn('1' to '9')).!
  private val nonHeadDigitsP: Parser[String] = P(CharIn('0' to '9')).!
  private val integerP: Parser[String] = P(headDigitsP ~ nonHeadDigitsP.rep()).map(r => r._2.foldLeft(r._1)(_ + _))

  val intP: Parser[Term] = P(zeroP | integerP).map(_.toInt).map(Term.Int)
  val termP: Parser[Term] = boolP | intP | ifP
}