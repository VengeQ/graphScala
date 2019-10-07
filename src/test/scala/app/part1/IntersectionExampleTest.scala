package app.part1

import org.scalatest.{FunSuite, Matchers}

class IntersectionExampleTest extends FunSuite with Matchers{

  test("Intersection Example test"){
    val firstList = List(1,3,5,7,9)
    val secondList = List(1,2,3,6,8,9)

    IntersectionExample.intersectionI(firstList,secondList) shouldBe List(1,3,9)
    IntersectionExample.intersectionF(firstList,secondList) shouldBe List(1,3,9)
  }

}
