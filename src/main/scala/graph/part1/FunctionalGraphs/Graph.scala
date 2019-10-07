package graph.part1.FunctionalGraphs


trait Graph[V] {
  def vertices: List[V]

  def edges: List[(V, V)]

  def addEdgs(a: V, b: V): Graph[V]

  def neighbours(vertex: V): List[V]
}

object Graph {
  def apply[V](adjList: Map[V, List[V]]): Graph[V] = new DirectedGraph(adjList)

  def apply[V]: Graph[V] = new DirectedGraph(Map.empty[V, List[V]])
}