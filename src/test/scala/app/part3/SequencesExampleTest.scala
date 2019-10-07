package app.part3

import org.scalatest.{FunSuite, Matchers}

class SequencesExampleTest extends FunSuite with Matchers {

  test("StreamTest") {
    SequencesExample.streamGenerator(5).toList shouldBe List(1, 2, 3, 4, 5)

    for (i <- 1 to 20)
      SequencesExample.fiboStreamGenerator(i) shouldBe SequencesExample.fiboClassicGenerator(i)
  }



}
