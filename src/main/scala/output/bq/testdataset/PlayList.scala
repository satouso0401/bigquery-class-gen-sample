package output.bq.testdataset

import java.time.format.DateTimeFormatter
import java.time.{LocalDate, LocalDateTime, LocalTime, ZonedDateTime}
import java.util.Base64
import scala.collection.JavaConverters._

case class PlayList(id: Long, song: String, time: Long, artist: String)

object PlayList {
  implicit class ToBqRow(val x: PlayList) {
    def toBqRow = { Map("id" -> x.id, "song" -> x.song, "time" -> x.time, "artist" -> x.artist) }.asJava
  }

}
