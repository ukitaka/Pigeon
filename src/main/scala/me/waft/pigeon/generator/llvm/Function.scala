package me.waft.pigeon.generator.llvm

case class Function(name: String, retType: String, args: Seq[String], stmt: Seq[String]) {

}

object Function {
  def mainFunction(): Function = Function("main", "i32", Seq(), Seq())
}
