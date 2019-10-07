package graph.part1

import scala.util.{Failure, Success, Try}

object RepresentingGraph {

  case class MatrixGraph(init: Array[String]) {
    private val connections = collection.mutable.ArrayBuffer.fill[Boolean](init.length, init.length)(false)
    val keys = init.zip(Stream.iterate(0)(_ + 1)).toMap

    def addFriend(p1: String, p2: String):Try[String] = {

      if (p1==p2) return Failure(new Exception("U can't use same names!"))

      keys.get(p1) match {
        case None => Failure(new NoSuchElementException(s"$p1"))
        case Some(x) => keys.get(p2) match {
          case None => Failure(new NoSuchElementException(s"$p2"))
          case Some(y) => addFriend(x, y, p1, p2)
        }
      }
    }

    def addFriend(i1: Int, i2: Int, name1:String="",name2:String="") = {
      if (scala.math.max(i1, i2) > init.length - 1)
        Failure[String](new java.lang.ArrayIndexOutOfBoundsException)

      else {
        connections synchronized {
          connections(i1)(i2) = true
          connections(i2)(i1) = true
        }
        Success[String](s"Now ${name1} and ${name2} are friends")
      }
    }

    def links = connections;

  }

}
