package com.github.tamaki.study.yoda.refactor

import scala.util.{Failure, Success, Try}

/**
 * Created by yohei.oda on 15/08/19.
 */
class RefactorImpl {
  val nameOpt = Option("aaa")

  nameOpt.map(findById)

  nameOpt.map(_ => None).getOrElse(Some("x"))

  def findById(s: String): Long = {
    s.length
  }
}

object Main {
  def main(args: Array[String]): Unit = {

    val x1: String = "abc"
    val x2: String = ""
    val x3: Option[String] = Some("abc")
    val x4: Option[String] = Some("")
    val x5: Option[String] = Some("12345")
    val x6: Option[String] = Some("not a number")

    val errors = new scala.collection.mutable.HashMap[String, String]()

    List(("x1", x1), ("x2", x2)).collect {
      case (label: String, value: String) if value.isEmpty => errors.put(label, "error.required")
    }

    List(("x3", x3), ("x4", x4)).collect {
      case (label: String, valueOpt: Option[String]) if valueOpt.map(x => !x.isEmpty).getOrElse(false) => errors.put(label, "error.required")
    }

    List(("x5", x5), ("x6", x6)).collect {
      case (label: String, valueOpt: Option[String]) if valueOpt.map(x => !x.isEmpty).getOrElse(false)
      => valueOpt.map { value =>
        Try(value.toInt) match {
          case Failure(_) => errors.put(label, "error.number")
          case Success(num) => num
        }
      }
    }

  }
}