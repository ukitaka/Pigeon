package me.waft.pigeon.parser

import me.waft.pigeon.AST.DeclTopLevel

trait Parser[+A] { lhs =>
  def run(location: Location): Result[A]

  def map[B](f: A => B): Parser[B] = new Parser[B] {
    def run(location: Location) = lhs.run(location).map(f)
  }

  def listOf[A](n: Int): Parser[List[A]] = ???

  def many: Parser[List[A]] = ???
  def many1: Parser[List[A]] = ???

  def product[B](p: Parser[B]): Parser[(A, B)] = ???

  def slice(): Parser[String] = ???
}

object Parser {
  def parseTranslationUnit(string: String): Parser[List[DeclTopLevel]] = ???

  def string(s: String): Parser[String] = ???

  def char(c: Char): Parser[Char] = string(c.toString).map(_.charAt(0))

  def success[A](a: A): Parser[A] = string("").map(_ => a)

}
