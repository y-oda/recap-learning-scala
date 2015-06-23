package com.github.tamaki.study.yoda.nnp

import com.sun.tools.javadoc.Start
import com.sun.xml.internal.ws.api.config.management.policy.ManagedServiceAssertion.NestedParameters

import scala.annotation.tailrec

/**
 * Created by yohei.oda on 2015/06/12.
 */
class NNP10 {

    // P01 (*) Find the last element of a list.
    @tailrec
    final def last(list: List[Int]): Int = {
      list match {
        case head::Nil => head
        case head::tail => last(tail)
        case _ => throw new IllegalArgumentException
      }
    }

    // P02 (*) Find the last but one element of a list.\
    @tailrec
    final def penultimate(list: List[Int]): Int = {
      list match {
        case _ if list.size<=2 => list(0)
        case head::tail=> penultimate(tail)
      }
    }

    def nth(n: Int, list: List[Int]): Int = {
      @tailrec
      def loop(n:Int, rest: List[Int], acc:Int): Int = {
        rest match {
          case _ if n == acc => list(0)
          case head::tail => loop(n,tail,acc+1)
        }
      }
      loop(n,list,0)
    }

    def length(list: List[Int]): Int = {
      @tailrec
      def loop(rest: List[Int], acc: Int):Int = {
        rest match {
          case Nil => acc
          case head :: tail => loop(tail,acc+1)
        }
      }
      loop(list,0)
    }

    def reverse(list: List[Int]): List[Int] = {
      @tailrec
      def loop(rest: List[Int], acc:List[Int]):List[Int] = {
        rest match {
          case Nil => acc
          case head::tail => loop(tail,head::acc)
        }
      }
      loop(list,List())
    }

    def isPalindrome(list: List[Int]): Boolean = {
      list match {
        case Nil => true
        case head::Nil => true
        case head::tail if head == tail.last => isPalindrome(tail.init)
        case _ => false
      }
    }

    def flatten(nested: List[Any]): List[Any] = {
      def loop(rest: List[Any],acc: List[Any]):List[Any]= {
        rest match {
          case Nil => acc
          case head :: tail if head.isInstanceOf[List[Any]] => loop(head.asInstanceOf[List[Any]], loop(tail, acc))
          case head :: tail => head :: loop(tail, acc)
        }
      }
      loop(nested,List())
    }

    def compress(list: List[Symbol]): List[Symbol] = {
      @tailrec
      def loop(rest: List[Symbol], acc: List[Symbol]): List[Symbol] = {
        rest match {
          case rest if acc == Nil => loop(rest.init,rest.last::Nil)
          case head::Nil if head.equals(acc.head) => acc
          case head::Nil => head::acc
          case head::tail if tail.last.equals(acc.head) => loop(rest.init,acc)
          case _ => loop(rest.init,rest.last::acc)
        }
      }
      loop(list,Nil)
    }

    def pack(list: List[Symbol]): List[List[Symbol]] = {
      @tailrec
      def loop(rest: List[Symbol], now: List[Symbol], acc: List[List[Symbol]]):List[List[Symbol]] = {
        rest match {
          case Nil => now::acc
          case head::tail if now == Nil => loop(tail,head::Nil,acc)
          case head::tail if head.equals(now.head) => loop(tail,head::now,acc)
          case head::tail => loop(tail,head::Nil,now::acc)
        }
      }
      loop(list,Nil,Nil).reverse
    }

    def encode(list: List[Symbol]): List[(Int, Symbol)] = {
//      @tailrec
      def loop(rest: List[Symbol], now: (Int,Symbol), acc: List[(Int, Symbol)]):List[(Int,Symbol)] = {
        rest match {
          case Nil => now::acc
          case head::tail if now._1 == 0 => loop(tail,(1,head),acc)
          case head::tail if head.equals(now._2) => loop(tail,(now._1 + 1, now._2),acc)
          case head::tail => loop(tail,(1,head),now::acc)
        }
      }
      loop(list.tail,(1,list.head),Nil).reverse
    }

}
