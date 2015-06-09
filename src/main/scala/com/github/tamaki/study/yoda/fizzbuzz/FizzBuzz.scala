package com.github.tamaki.study.yoda.fizzbuzz

/**
 * Created by yohei.oda on 2015/06/09.
 */
class FizzBuzz {
  def doFizzBuzz {
    (1 to 100).foreach(x =>
        x match {
          case x if (x % 3 == 0 && x % 5 == 0) => println("FizzBuzz")
          case x if (x % 5 == 0) => println("Buzz")
          case x if (x % 3 == 0) => println("Fizz")
          case _ => println(x)
        }
    )
  }
}
