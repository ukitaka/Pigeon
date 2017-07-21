package me.waft.pigeon.generator.llvm

sealed trait Identifier

sealed trait LocalIdentifier extends Identifier

object LocalIdentifier {
  case class Named(name: String) extends LocalIdentifier
  case class Anonymous(n: Int) extends LocalIdentifier
}

sealed trait GlobalIdentifier extends Identifier

object GlobalIdentifier {
  case class Named(name: String) extends GlobalIdentifier
  case class Anonymous(n: Int) extends GlobalIdentifier
}
