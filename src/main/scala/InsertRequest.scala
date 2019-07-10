import java.time.ZonedDateTime

import com.google.cloud.bigquery.{BigQueryOptions, InsertAllRequest, TableId}
import output.bq.testdataset.ConveyorBeltSushi

import scala.util.{Failure, Success, Try}

object InsertRequest extends App {

  val bigQuery = BigQueryOptions.getDefaultInstance.getService

  val datasetId = "test_dataset"
  val tableId   = "conveyor_belt_sushi"

  val row1 = ConveyorBeltSushi(1, "Magro", "Ready", ZonedDateTime.now().minusHours(3)).toBqRow
  val row2 = ConveyorBeltSushi(2, "Sake", "Eat", ZonedDateTime.now().minusHours(2)).toBqRow
  val row3 = ConveyorBeltSushi(3, "French fries", "Ready", ZonedDateTime.now().minusHours(2)).toBqRow
  val row4 = ConveyorBeltSushi(1, "Magro", "Disposal", ZonedDateTime.now().minusHours(1)).toBqRow
  val row5 = ConveyorBeltSushi(4, "Toki sude ni osushi", "Disposal", ZonedDateTime.now()).toBqRow

  val response = Try {
    bigQuery.insertAll(
      InsertAllRequest
        .newBuilder(TableId.of(datasetId, tableId))
        .addRow(row1)
        .addRow(row2)
        .addRow(row3)
        .addRow(row4)
        .addRow(row5)
        .build)
  }

  response match {
    case Success(v) if v.hasErrors => println("error: " + v.getInsertErrors)
    case Success(_)                => println("success")
    case Failure(e)                => e.printStackTrace()
  }

}
