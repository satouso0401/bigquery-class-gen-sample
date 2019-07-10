package output.bq.testdataset

import java.time.format.DateTimeFormatter
import java.time.{LocalDate, LocalDateTime, LocalTime, ZonedDateTime}
import java.util.Base64
import scala.collection.JavaConverters._

case class ConveyorBeltSushi(
    sushiId: Long,
    sushiName: String,
    event: String,
    eventTime: ZonedDateTime
)

object ConveyorBeltSushi {
  implicit class ToBqRow(val x: ConveyorBeltSushi) {
    def toBqRow = {
      Map(
        "sushi_id"   -> x.sushiId,
        "sushi_name" -> x.sushiName,
        "event"      -> x.event,
        "event_time" -> x.eventTime.toInstant.getEpochSecond
      )
    }.asJava
  }

}
