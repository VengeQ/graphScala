package app.part1

import scala.collection.mutable.{MutableList => Ml}

object IntersectionExample {

  def intersectionI(a:List[Int], b:List[Int]):List[Int] = {
    val result = new Ml[Int]

    for (i <- a)
      for (j <- b) if (i==j) result += i

    result.toList
  }

  def intersectionF(a:List[Int], b:List[Int]):List[Int] = for (i <- a; j <- b; if (i==j)) yield i

}
