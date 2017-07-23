package me.waft.pigeon.generator.llvm

trait BinaryOperation

object BinaryOperation {
  case class Add(op1: Int, op2: Int) extends BinaryOperation
  case class Fadd(op1: Float, op2: Float) extends BinaryOperation
  case class Sub(op1: Int, op2: Int) extends BinaryOperation
}
