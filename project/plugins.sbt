addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.6.3")
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.2.0")
addSbtPlugin("org.portable-scala" % "sbt-scala-native-crossproject" % "1.2.0")
addSbtPlugin("org.scala-js" % "sbt-jsdependencies" % "1.0.2")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.10.1")
addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.4.5")
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.9.13")
addSbtPlugin("com.github.sbt" % "sbt-release" % "1.1.0")
addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.1.2")
addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.4.3")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "2.0.1")
addSbtPlugin("com.typesafe" % "sbt-mima-plugin" % "1.1.0")
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.3.2")
addSbtPlugin("com.evolution" % "sbt-artifactory-plugin" % "0.0.2")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.0.0-RC1")

libraryDependencies ++= Seq(
  "org.openjdk.jmh" % "jmh-core" % "1.35",
  "org.openjdk.jmh" % "jmh-generator-asm" % "1.35",
  "org.openjdk.jmh" % "jmh-generator-bytecode" % "1.35",
  "org.openjdk.jmh" % "jmh-generator-reflection" % "1.35"
)