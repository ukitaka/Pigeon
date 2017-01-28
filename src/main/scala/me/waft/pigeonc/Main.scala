package me.waft.pigeonc

class Main extends xsbti.AppMain {
  def run(configuration: xsbti.AppConfiguration): xsbti.MainResult = {
    val scalaVersion = configuration.provider.scalaProvider.version

    println("Hello world!  Running Scala " + scalaVersion)
    configuration.arguments.foreach(println)

    new Exit(0)
  }
  class Exit(val code: Int) extends xsbti.Exit
}

