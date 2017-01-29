package me.waft.pigeon.parser

sealed trait Result[+A]
case class Success[+A](get: A, charsConsumed: Int) extends Result[A]
case class Failure(error: Error) extends Result[Nothing]
