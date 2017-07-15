package me.waft.pigeon.ast


sealed trait Term {}

object Term {
  case object True extends Term
  case object False extends Term
  case class If(cond: Term, tru: Term, fls: Term) extends Term
  case class Int(n: scala.Int) extends Term
  case class Ops(lhs: Term, operator: Operator,rhs: Term) extends Term
}
