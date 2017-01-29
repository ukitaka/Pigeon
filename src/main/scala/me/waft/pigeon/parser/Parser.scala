package me.waft.pigeon.parser

import me.waft.pigeon.AST.DeclTopLevel

trait Parser[+A] {

}

object Parser {
  def parseTranslationUnit(string: String): Parser[Seq[DeclTopLevel]] = ???
}

