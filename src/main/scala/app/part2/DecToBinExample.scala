package app.part2

import scala.annotation.tailrec

object DecToBinExample {

  def decToBin(decimal: Int): String = {

    @tailrec def go(d: Int, accumulate: String): String = d / 2 match {
      case 0 => d % 2 + accumulate
      case x@_ => go(x, d % 2 + accumulate)
    }

    go(decimal, "")
  }

  def decToBin2(decimal: Int): String = decimal / 2 match {
    case 0 => decimal % 2 toString
    case x@_ => decToBin2(x) + decimal % 2
  }

  def decToBin3(value: Int) = Iterator
    .iterate(value)(_ / 2)
    .takeWhile(_ > 0)
    .map(_ % 2)
    .mkString.reverse



}
