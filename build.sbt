name := "bigquery-class-gen-sample"

version := "0.1"

scalaVersion := "2.12.8"

//lazy val root = (project in file(".")).dependsOn(bqClassGen)
//lazy val bqClassGen = ClasspathDependency(RootProject(uri("git://git@github.com:satouso0401/repo.git#customize_mapping")), Some("bigquery-class-gen"))

libraryDependencies += "com.github.satouso0401" %% "bigquery-class-gen" % "0.2.1"
