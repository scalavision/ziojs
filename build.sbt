import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

lazy val laminarV      = "0.14.2"
lazy val airstreamV    = "0.14.2"
lazy val lamiNext      = "0.14.2"
lazy val scalajsDomV   = "2.0.0"
lazy val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name         := "ziojs",
    version      := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
    }, //.outputPatterns
    scalaJSUseMainModuleInitializer := true,
    // artifactPath in (Compile, fastOptJS) := baseDirectory.value / "ui" / "js" / "app.js",
    Compile / fastOptJS / artifactPath := baseDirectory.value / "ui" / "js" / "app.js",
    libraryDependencies ++= Seq(
      "com.raquo"          %%% "laminar"       % laminarV,
      "com.raquo"          %%% "airstream"     % airstreamV,
      "com.lihaoyi"        %%% "sourcecode"    % "0.2.7",
      "org.scala-js"       %%% "scalajs-dom"   % scalajsDomV,
      "io.laminext"        %%% "websocket"     % lamiNext,
      "io.laminext"        %%% "ui"            % lamiNext,
      //"org.wvlet.airframe" %%% "airframe-ulid" % "22.2.0",
      //"org.wvlet.airframe" %%% "airframe-ulid" % "22.2.0",
      "dev.zio"         %%% "zio"                 % "2.0.0-RC2",
      //"org.scalablytyped" %%% "reduxjs__toolkit" % "1.6.2-6bcec8",
      //"org.scalameta" %% "munit" % "0.7.21" % Test
      // "dev.zio" %%% "zio-test-magnolia" % "1.0.3" % "test",
      //("com.lihaoyi" %%% "utest" % "0.7.5" % "test")
      //.withDottyCompat(scalaVersion.value)
    )
  )
