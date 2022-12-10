package com.github.plokhotnyuk.jsoniter_scala.benchmark

import java.nio.charset.StandardCharsets.UTF_8

class GitHubActionsAPIReadingSpec extends BenchmarkSpecBase {
  def benchmark: GitHubActionsAPIReading = new GitHubActionsAPIReading {
    setup()
  }

  "GitHubActionsAPIReading" should {
    "read properly" in {
      benchmark.borer() shouldBe benchmark.obj
      benchmark.circe() shouldBe benchmark.obj
      benchmark.circeJsoniter() shouldBe benchmark.obj
      benchmark.jsoniterScala() shouldBe benchmark.obj
      benchmark.playJson() shouldBe benchmark.obj
      benchmark.playJsonJsoniter() shouldBe benchmark.obj
      benchmark.smithy4sJson() shouldBe benchmark.obj
      //FIXME: uPickle throws java.lang.NullPointerException: Cannot invoke "upickle.core.Visitor.visitString(java.lang.CharSequence, int)" because the return value of "upickle.core.ObjArrVisitor.subVisitor()" is null
      //benchmark.uPickle() shouldBe benchmark.obj
      benchmark.zioJson() shouldBe benchmark.obj
    }
    "fail on invalid input" in {
      val b = benchmark
      b.jsonBytes = "[]".getBytes(UTF_8)
      intercept[Throwable](b.borer())
      intercept[Throwable](b.circe())
      intercept[Throwable](b.circeJsoniter())
      intercept[Throwable](b.jsoniterScala())
      intercept[Throwable](b.playJson())
      intercept[Throwable](b.playJsonJsoniter())
      intercept[Throwable](b.smithy4sJson())
      //FIXME: uPickle throws java.lang.NullPointerException: Cannot invoke "upickle.core.Visitor.visitString(java.lang.CharSequence, int)" because the return value of "upickle.core.ObjArrVisitor.subVisitor()" is null
      //intercept[Throwable](b.uPickle())
      intercept[Throwable](b.zioJson())
    }
  }
}