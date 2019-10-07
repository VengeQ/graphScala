package graph.part1

import org.scalatest.{FlatSpec, FunSuite, Matchers}

class DirectedGraphTest extends FlatSpec with Matchers {

  import FunctionalGraphs._

  val graph = new DirectedGraph[Int](Map(1 -> List(2, 4, 5), 2 -> List(1, 5)))
  "Main constructor" should "return new graph" in {
    graph.isInstanceOf[DirectedGraph[Int]] shouldBe true

    graph.vertices.foreach(println)
    graph.edges.foreach(println)
  }

  "vertices" should "return all initial nodes" in {
    graph.vertices shouldBe List(1, 2)
  }


  "edges" should "return all edges like List of Tuples(start, finish)" in {
    graph.edges shouldBe List((1, 2), (1, 4), (1, 5), (2, 1), (2, 5))
  }

  "neighbours" should "return all neighbours of vertice" in {
    graph.neighbours(2) shouldBe List(1,5)
    graph.neighbours(1) shouldBe List(2,4,5)
    graph.neighbours(4) shouldBe Nil
  }


  "add edge" should "return new graph" in {
    graph.addEdgs(4,1) shouldBe new DirectedGraph[Int](Map(1 -> List(2, 4, 5), 2 -> List(1, 5), 4 -> List(1)))
    graph.addEdgs(4,1).addEdgs(2,4) shouldBe new DirectedGraph[Int](Map(1 -> List(2, 4, 5), 2 -> List(4,1, 5), 4 -> List(1)))
  }
}
