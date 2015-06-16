package com.github.tamaki.study.yoda.tailrec

/**
 * Created by yohei.oda on 2015/06/16.
 */
object Rec {
  def sum(n:Int):Int={
      def loop(n:Int, acc:Int):Int={
        n match {
          case 0 => acc
          case _ =>  loop(n - 1, n + acc)
        }
      }
      loop(n,0)
  }
}
