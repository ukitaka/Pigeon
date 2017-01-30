package me.waft.pigeon.parser

case class Location(input: String, offset: Int = 0) {
  def advanceBy(n: Int) = copy(offset = offset+n)
}
