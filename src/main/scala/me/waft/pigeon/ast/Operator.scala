package me.waft.pigeon.ast

sealed trait Operator

object Operator {
  case object Plus extends Operator
  case object Minus extends Operator
  case object Times extends Operator
  case object Div extends Operator
}
