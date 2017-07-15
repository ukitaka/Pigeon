package me.waft.pigeonc

class Main extends xsbti.AppMain {
  def run(configuration: xsbti.AppConfiguration): xsbti.MainResult = {
    new Exit(0)
  }
  class Exit(val code: Int) extends xsbti.Exit
}
