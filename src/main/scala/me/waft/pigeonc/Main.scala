package me.waft.pigeonc

import me.waft.pigeon.parser.Parser

class Main extends xsbti.AppMain {
  def run(configuration: xsbti.AppConfiguration): xsbti.MainResult = {
    // val scalaVersion = configuration.provider.scalaProvider.version
    // configuration.arguments.foreach(println)
    Parser.parse()

    new Exit(0)
  }
  class Exit(val code: Int) extends xsbti.Exit
}
