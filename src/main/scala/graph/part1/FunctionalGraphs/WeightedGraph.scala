package graph.part1.FunctionalGraphs

case class WeightedEdge[V](destination: V, weight: Int)

class WeightedGraph[V](adjList: Map[V, List[WeightedEdge[V]]]) extends Graph[V] {
  override def vertices: List[V] = adjList.keys.toList

  override def edges: List[(V, V)] = adjList.toList.flatMap {
    case (l, w) => w.map(x => (l, x.destination))
  }

  def addEdgs(a: V, weightedEdge: WeightedEdge[V]): WeightedGraph[V] = {
    val aNeighbours = weightedEdge +: adjList.getOrElse(a, Nil)
    new WeightedGraph(adjList + (a -> aNeighbours))
  }

  override def addEdgs(a: V, b: V): WeightedGraph[V] = addEdgs(a, new WeightedEdge(b, 0))

  override def neighbours(vertex: V): List[V] = adjList.getOrElse(vertex, Nil).map(_.destination)

  def neighboursWeight(vertex: V): List[WeightedEdge[V]] = adjList.getOrElse(vertex, Nil)
}
