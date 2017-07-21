package me.waft.pigeon.generator.llvm.`type`

trait Type

sealed trait PrimitiveType extends Type
case object Float extends PrimitiveType
case object Double extends PrimitiveType
//case object FP128 extends PrimitiveType
//case object X86FP80 extends PrimitiveType
//case object PPCFP128 extends PrimitiveType
case object Void extends PrimitiveType
case object Label extends PrimitiveType
case object Metadata extends PrimitiveType

sealed trait DerivedType extends Type
case class Integer(n: scala.Int)  extends Type
