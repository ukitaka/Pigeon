package me.waft.pigeon.generator.llvm

trait Instruction

case class Ret(ty: String, value: String) extends Instruction
