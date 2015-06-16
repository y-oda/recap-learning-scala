package com.github.tamaki.study.yoda.nnp

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
        case list if list.size<=2 => list(0)
        case head::tail=> penultimate(tail)
      }
    }

    def nth(n: Int, list: List[Int]): Int = {
      @tailrec
      def loop(n:Int, list: List[Int], acc:Int): Int = {
        list match {
          case list if n == acc => list(0)
          case head::tail => loop(n,tail,acc+1)
        }
      }
      loop(n,list,0)
    }

    def length(list: List[Int]): Int = {
      @tailrec
      def loop(list: List[Int], acc: Int):Int = {
        list match {
          case Nil => acc
          case head :: tail => loop(tail,acc+1)
        }
      }
      loop(list,0)
    }

    def reverse(list: List[Int]): List[Int] = {
      @tailrec
      def loop(list: List[Int], acc:List[Int]):List[Int] = {
        list match {
          case Nil => acc
          case head::tail => loop(tail,head::acc)
        }
      }
      loop(list,List())
    }

    def isPalindrome(list: List[Int]): Boolean = {
      list == reverse(list)
    }

    def flatten(nested: List[Any]): List[Any] = {
      ???
    }

    def compress(list: List[Symbol]): List[Symbol] = {
      ???
    }

    def pack(list: List[Symbol]): List[List[Symbol]] = {
      ???
    }

    def encode(list: List[Symbol]): List[(Int, Symbol)] = {
      ???
    }

}
