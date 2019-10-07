package graph.part1.FunctionalGraphs

class UndirectedGraph[V](val adjList: Map[V, List[V]]) extends DirectedGraph[V](adjList) {

  override def addEdgs(a: V, b: V): Graph[V] = {
    val aNeighbours = b +: neighbours(a)
    val bNeighbours = a +: neighbours(b)
    new UndirectedGraph[V](adjList + (a -> aNeighbours, b -> bNeighbours))
  }

  override def equals(other: Any): Boolean = other match {
    case that: UndirectedGraph[V] => if (this.edges == that.edges) true else false
    case _ => false
  }

  override def hashCode(): Int = (super.hashCode, adjList).##

}

object UndirectedGraph {
  def apply[V](adjList: Map[V, List[V]]): UndirectedGraph[V] = {
    val connects = adjList.foldLeft(adjList) { case (accum, (initKey, initValue)) =>
      val reverse = initValue.flatMap(x => Map(x -> initKey))
      reverse.foldLeft(accum) { case (temporary, (k, v)) =>
        temporary + (k -> (v :: temporary.getOrElse(k, Nil)))
      }
    }
    new UndirectedGraph[V](connects)
  }

}
