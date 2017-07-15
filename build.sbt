name := """pigeonc"""

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies += "com.lihaoyi" %% "fastparse" % "0.4.3"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

lazy val root = (project in file(".")).
  enablePlugins(ConscriptPlugin).
  settings()

