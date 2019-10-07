package app.part2

import org.scalatest.FunSuite

class DecToBinExampleTest extends FunSuite{

  test("Decimal to binary test"){
    println(DecToBinExample.decToBin(183))
    println(DecToBinExample.decToBin2(183))
    println(DecToBinExample.decToBin3(183))
  }

}
