import sbt._

object Dependencies {

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val shapeless = "com.chuusai" %% "shapeless" % "2.3.3"
  lazy val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.13.5"
  lazy val scalaCsv = "com.github.tototoshi" %% "scala-csv" % "1.3.5"
  lazy val circeVersion = "0.9.0"
  lazy val circeCore = "io.circe" %% "circe-core" % circeVersion
  lazy val circeGeneric = "io.circe" %% "circe-generic" % circeVersion
  lazy val circeParser = "io.circe" %% "circe-parser" % circeVersion
  lazy val catsCore = "org.typelevel" %% "cats-core" % "1.0.1"

}
