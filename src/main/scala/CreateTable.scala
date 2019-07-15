import bq.classgen.BqUtil
import com.google.cloud.bigquery.BigQueryOptions

object CreateTable extends App {

  implicit val bigQuery = BigQueryOptions.getDefaultInstance.getService

  val datasetId = "test_dataset"
  val tableId   = "play_list"

  val schemaJson =
    """[
      |  {"name": "id", "mode": "REQUIRED", "type": "INT64"},
      |  {"name": "song", "mode": "REQUIRED", "type": "STRING"},
      |  {"name": "time", "mode": "REQUIRED", "type": "INT64"},
      |  {"name": "artist", "mode": "REQUIRED", "type": "STRING"}
      |]
    """.stripMargin

  BqUtil.createTableUsingJson(datasetId, tableId, schemaJson)

  val sql =
    s"create table `$datasetId.conveyor_belt_sushi`(sushi_id int64, sushi_name string, event string, event_time timestamp)"

  BqUtil.createTableUsingSql(sql)

}
