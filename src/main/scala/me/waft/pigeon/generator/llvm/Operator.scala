package me.waft.pigeon.generator.llvm

trait BinaryOperation

object BinaryOperation {
  case class Add(op1: Int, op2: Int) extends BinaryOperation
}
