package graph.part1

import org.scalatest.{FlatSpec, Matchers}

class UndirectedGraphTest extends FlatSpec with Matchers {

  import FunctionalGraphs._

  val graph = new UndirectedGraph[Int](Map(1 -> List(2, 4, 5), 2 -> List(1, 5), 4 -> List(2), 5 -> List(1, 2)))

  "newEdge" should "add new edge" in {
    graph.addEdgs(1, 6) shouldBe new UndirectedGraph[Int](Map(1 -> List(6, 2, 4, 5), 2 -> List(1, 5), 4 -> List(2), 5 -> List(1, 2), 6 -> List(1)))
    graph.addEdgs(4, 5) shouldBe new UndirectedGraph[Int](Map(1 -> List(2, 4, 5), 2 -> List(1, 5), 4 -> List(5, 2), 5 -> List(4, 1, 2)))
  }


  "Create undirected graph from directed graph" should "create all connects" in{
    val graph =  UndirectedGraph[Int](Map(1 -> List(4,3,2), 2 -> List(4), 3 -> List(4)))

    graph.edges.foreach(println)

  }
}
