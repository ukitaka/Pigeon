package me.waft.pigeon.ast

sealed trait Operator

object Operator {
  case object Add extends Operator
  case object Sub extends Operator
  case object Mul extends Operator
  case object Div extends Operator
}
