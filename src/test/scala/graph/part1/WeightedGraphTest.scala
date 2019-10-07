package graph.part1

import org.scalatest.{FlatSpec, Matchers}

class WeightedGraphTest extends FlatSpec with Matchers {

  import FunctionalGraphs._

  val adjList = Map(
    1 -> List(WeightedEdge(2, 10), WeightedEdge(3, 11)),
    2 -> List(WeightedEdge(1, 10), WeightedEdge(3, 13))
  )
  val graph = new WeightedGraph[Int](adjList)

  "newEdge" should "add new edge" in {
    graph.addEdgs(1, 4).edges.sorted shouldBe List((1, 2), (1, 3), (1, 4), (2, 1), (2, 3))
  }

  "edges" should "return edges" in {
    graph.edges.sortWith((x, y) => {
      x._1 < y._1 || (x._1 == y._1 && x._2 < y._2)})shouldBe List((1, 2), (1, 3), (2, 1), (2, 3))
  }

  "vertices" should "return 1 2 3 " in{
    graph.vertices.sorted shouldBe List(1,2)
  }
  "neighbours" should "return 2 3 " in{
    graph.neighbours(1).sorted shouldBe List(2,3)
  }
  "neighboursWeight" should "return List of edges with weigth" in {
    graph.neighboursWeight(1) shouldBe List(WeightedEdge(2, 10), WeightedEdge(3, 11))
  }
}
