import bq.classgen.BigQueryCaseClassGenerator
import com.google.cloud.bigquery.BigQueryOptions

object GenerateClass extends App {

  implicit val bigQuery = BigQueryOptions.getDefaultInstance.getService

  val datasetId = "test_dataset"
  val outputDir = "src/main/scala"
  val outputPkg = "output.bq.testdataset"

  BigQueryCaseClassGenerator().run(datasetId, outputDir, outputPkg)

}
