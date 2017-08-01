package me.waft.pigeon.generator.llvm

trait IRRepresentable[A] {
  def genIR(a: A): String
}

object IRRepresentable {
  implicit val funcition = new IRRepresentable[Function] {
    def genIR(a: Function): String =
      s"""
         | define ${a.retType} @${a.name}() {
         |
         | }
       """.stripMargin
  }
}