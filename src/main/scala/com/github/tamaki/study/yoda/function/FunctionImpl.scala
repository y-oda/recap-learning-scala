package com.github.tamaki.study.yoda.function

/**
 * Created by yohei.oda on 15/08/11.
 */
class FunctionImpl {
  def timeit[R](f: =>R): Unit = {
    val start = System.currentTimeMillis()
    println("""""")
    println(s"start: $start")
    f
    val end = System.currentTimeMillis()
    println(s"end: $end")
    println(s"time: ${end - start}")
  }

  def createAdder(a: Int) = (b:Int) => a + b

  def area(a: Double) = (b: Int) => a * b.toDouble * b.toDouble


}
