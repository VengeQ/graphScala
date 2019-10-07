package graph.part1

import org.scalatest.{FunSuite, Matchers}

class Part1Test extends FunSuite with Matchers {

  test("Matrix represent of graph") {
    import graph.part1.RepresentingGraph._

    val friends = MatrixGraph(Array("Ann", "John", "Jane", "Abby"))
    friends.keys.foreach(println)
    val j = (friends.addFriend("Ann", "Jane"))

    println(j)


    //friends.links.foreach(x => println(x))

  }

  test("FlatMapTest") {
    val a = Map(1 -> List(2, 3, 4)).map {
      case (v, ne) =>
        ne.map(x => (v, x))
    }


    val b = Map(1 -> List(2, 3))

    val c =b.flatMap{ case (v, ne) =>
      ne.map(x => (x, v))
    }.toList

    println(c)
  }
}
