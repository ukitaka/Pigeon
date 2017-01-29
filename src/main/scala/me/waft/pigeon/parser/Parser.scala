package me.waft.pigeon.parser

import me.waft.pigeon.AST.DeclTopLevel

trait Parser[+A] { lhs =>
  def run(location: Location): Result[A]

  def map[B](f: A => B): Parser[B] = new Parser[B] {
    def run(location: Location) = lhs.run(location).map(f)
  }
}

object Parser {
  def parseTranslationUnit(string: String): Parser[Seq[DeclTopLevel]] = ???

  def string(s: String): Parser[String] = ???

  def char(c: Char): Parser[Char] = string(c.toString).map(_.charAt(0))
}
