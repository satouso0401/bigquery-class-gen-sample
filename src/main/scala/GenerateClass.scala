import bq.classgen.BigQueryCaseClassGenerator

object GenerateClass extends App {

  val datasetId = "test_dataset"
  val outputDir = "src/main/scala"
  val outputPkg = "output.bq.testdataset"

  BigQueryCaseClassGenerator.run(datasetId, outputDir, outputPkg)

}
