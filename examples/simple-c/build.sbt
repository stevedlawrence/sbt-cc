import scala.collection.immutable.ListSet

ThisBuild / name         := "simple-c"
ThisBuild / version      := "0.1"
ThisBuild / scalaVersion := "2.13.1"

val helloExe = Program("hello")

lazy val simpleC = (project in file("."))
  .enablePlugins(CcPlugin)
  .settings(
    Compile / ccTargets := ListSet(helloExe),
    Compile / cSources  := Map(
      helloExe -> Seq(
        baseDirectory.value / "hello.c",
        baseDirectory.value / "hello_util.c"
      )
    ),
  )

/*

val a_out = Program("a.out")
val b_out = Program("b.out")

lazy val simpleC = (project in file("."))
  .enablePlugins(CcPlugin)
  .settings(
      cCompiler := "cc",

      Compile / ccTargets    := Set(a_out, b_out),

      Compile / cFlags       := Map[Target,Seq[String]](
        a_out -> Seq("-Wall", "-DMACRO_TEST=HELLO"),
        (a_out and (baseDirectory.value / "test2.c")) -> Seq("-Wall", "-DMACRO_TSET=HELLO2")
      ).withDefaultValue(Seq("-Wall")),

      Compile / cSourceFiles := Map(
        a_out -> Seq(
          baseDirectory.value / "test.c",
          baseDirectory.value / "test2.c"
        ),

        b_out -> Seq(
          baseDirectory.value / "test.c"
        ),
      ),
    )*/