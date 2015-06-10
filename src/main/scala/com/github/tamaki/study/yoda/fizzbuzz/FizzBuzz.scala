package com.github.tamaki.study.yoda.fizzbuzz

/**
 * Created by yohei.oda on 2015/06/09.
 */
class FizzBuzz {
  def doFizzBuzz = {
    (1 to 100).foreach(x =>
        x match {
          case x if (x % 3 == 0 && x % 5 == 0) => println("FizzBuzz")
          case x if (x % 5 == 0) => println("Buzz")
          case x if (x % 3 == 0) => println("Fizz")
          case _ => println(x)
        }
    )
  }

  def doFizzBuzz2 = {
    //TODO
  }

  def doFizzBuzz3 = {
    (1 to 100).filter(x => x % 2 != 0).foreach(x =>
      x match {
        case x if (x % 15 == 0) => println("FizzBuzz")
        case x if (x % 5 == 0) => println("Buzz")
        case x if (x % 3 == 0) => println("Fizz")
        case _ => println(x)
      }
    )
  }

  def doFizzBuzz4 = {
    val answer = (1 to 100).map(x =>
      x match {
        case x if x % 15 == 0 => "FizzBuzz"
        case x if x % 5 == 0 => "Buzz"
        case x if x % 3 == 0 => "Fizz"
        case _ => x
      }
    ).mkString(",")
    println(answer)
  }

  def doFizzBuzz5 = {
    val answer = (1 to 100).map(x =>
      x match {
        case x if x % 15 == 0 => "FizzBuzz"
        case x if x % 5 == 0 => "Buzz"
        case x if x % 3 == 0 => "Fizz"
        case _ => x.toString
      }
    ).map(x =>
      try {
        x.toInt
      } catch{
        case e:Exception => 0
      }
    ).fold(0)((x,z) => x + z)
    println(answer)
  }
}
