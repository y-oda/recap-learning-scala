package com.github.tamaki.study.yoda.wordcount

/**
 * Created by yohei.oda on 2015/06/04.
 */
//------------------------------------------------------
// ワードカウント問題
// https://gist.github.com/j5ik2o/7210762
//------------------------------------------------------

class WordCount {
  def countFruitsFromLines(lines: List[String]): Map[String, Int] = {
    lines.flatMap(str => str.split(" ")).groupBy(identity).mapValues(_.size)
  }

  val lines = List("apple banana", "orange apple mango", "kiwi papaya orange", "mango orange muscat apple")
  val fruitsCounts = countFruitsFromLines(lines)
  if (fruitsCounts == Map("banana" -> 1, "muscat" -> 1, "orange" -> 3, "mango" -> 2, "apple" -> 3, "kiwi" -> 1, "papaya" -> 1)) {
      println("正解")
  } else {
    println("不正解")
  }
}
