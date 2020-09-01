import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

import scala.collection.mutable.ListBuffer

//Adding index at the end of each element
object Test {

  def main(args: Array[String]): Unit = {

    val days = List("  Sunday  ", "Monday", "  Tuesday  ", "Wednesday", "Thursday", "Friday", "Saturday",
      "  Sunday  ", "Monday", "  Tuesday  ", "Wednesday", "Thursday", "Friday", "Saturday")

    //val days = Array("  Sunday  ")

    var output = new ListBuffer[String]()
    for ((day, count) <- days.zip(Stream from 1)) {
      output += day + count
    }
    val pipedListOfRS = output.toList.mkString("|")

    println(pipedListOfRS)

    val list = days.zip(Stream from 1).map((item) => item._1 + "%03d".format(item._2))

    val pipeRS = list.toList.mkString("|")
    //val list = days.zip(Stream from 1).mkString
    println(pipeRS)
  }
}
