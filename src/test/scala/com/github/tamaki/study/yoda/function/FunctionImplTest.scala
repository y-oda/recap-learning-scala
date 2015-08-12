package com.github.tamaki.study.yoda.function

import org.scalatest.FunSuite

/**
 * Created by yohei.oda on 15/08/11.
 */
class FunctionImplTest extends FunSuite {
  val func:Function0[Unit] = () => {
    Thread.sleep(100)
    println("Hello, World!")
  }

  val f = new FunctionImpl
  f.timeit{
    Thread.sleep(100)
    println("Hello, World!")
  }

  val adder3 = f.createAdder(3)
  println(adder3(2))

  val area314 = f.area(3.14)
  println(area314(10))

  val area3 = f.area(3)
  println(area3(10))

}
