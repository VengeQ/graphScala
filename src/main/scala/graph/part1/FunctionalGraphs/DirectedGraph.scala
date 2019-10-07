package graph.part1.FunctionalGraphs

class DirectedGraph[V](adjList: Map[V, List[V]]) extends Graph[V] {
  override def vertices: List[V] = adjList.keys.toList


  override def edges: List[(V, V)] = adjList.toList.flatMap {
    case (v, ne) => ne.map(n => (v, n))
  }

  override def addEdgs(a: V, b: V): Graph[V] = {
    val aNeighbours = b +: neighbours(a)
    new DirectedGraph(adjList + (a -> aNeighbours))
  }

  override def neighbours(vertex: V): List[V] = adjList.getOrElse(vertex, Nil)


  //def canEqual(other:Any) :Boolean= if (!other.isInstanceOf[DirectedGraph[V]]) false else true
  override def equals(other: Any): Boolean = other match{
    case that:DirectedGraph[V] => if (this.edges == that.edges) true else false
    case _ => false
  }

  override def hashCode(): Int = (super.hashCode, adjList).##
}

