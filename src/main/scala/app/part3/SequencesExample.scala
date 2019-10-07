package app.part3

object SequencesExample {

  def streamGenerator(count:Int) = Stream.iterate(1)(x => x+1).take(count)


  def fiboClassicGenerator(count:Int) = (1 until count).foldLeft((0,1))((v, _) => (v._2, v._1 + v._2))._1
  def fiboStreamGenerator(value:Int) = Stream.iterate((0,1))((x) => (x._2, x._1 + x._2)).take(value).last._1

}
