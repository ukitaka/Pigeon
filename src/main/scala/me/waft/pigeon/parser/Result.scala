package me.waft.pigeon.parser

sealed trait Result[+A] { lhs =>
  def map[B](f: A => B): Result[B] = lhs match {
    case Success(get, charsConsumed) => Success(f(get), charsConsumed)
    case Failure(error) => Failure(error)
  }

  def flatMap[B](f: A => Result[B]): Result[B] = lhs match {
    case Success(get, charsConsumed) => f(get)
    case Failure(error) => Failure(error)
  }

}

case class Success[+A](get: A, charsConsumed: Int) extends Result[A]
case class Failure(error: Error) extends Result[Nothing]
