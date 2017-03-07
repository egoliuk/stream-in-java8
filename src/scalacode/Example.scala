package scalacode

/**
  * Created by yevgen on 27.02.17.
  */
object Example {
  def main(args: Array[String]): Unit = {
    (0 to 9)
      .map("*" * _)
      .foreach(println _)
  }
}
