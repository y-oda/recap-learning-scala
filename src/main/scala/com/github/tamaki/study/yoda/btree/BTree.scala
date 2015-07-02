package com.github.tamaki.study.yoda.btree

import scala.collection.immutable.Stream.Empty

/**
 * Created by yohei.oda on 2015/06/25.
 */
trait Node

case class Branch(left:Node, value: Int, right: Node) extends Node

case class Leaf(value:Int) extends Node

object BTree {

  def apply(list:List[Int]):BTree={
    def loop(lst:List[Int]):Node = {
      lst match {
        case _ if lst.size % 2 == 0 => throw new IllegalArgumentException
        case _ if lst.size == 1 => Leaf(lst(0))
        case _ => {
          val mid = lst.size / 2
          val left = lst.take(mid)
          val right = lst.drop(mid+1)
            Branch(loop(left), lst(mid), loop(right))
        }
      }
    }
    BTree(loop(list))
  }
}

case class BTree(node: Node) {

  def size:Int = {
    node match {
      case Branch(left,value,right) => BTree(left).size + 1 + BTree(right).size
      case Leaf(_) => 1
    }
  }

  def max:Int = {
    node match {
      case Branch(left,value,right) => BTree(right).max
      case Leaf(value) => value
    }
  }

  def min:Int = {
    node match {
      case Branch(left,value,right) => BTree(left).min
      case Leaf(value) => value
    }
  }

  def sum:Int = {
    node match {
      case Branch(left,value,right) => BTree(left).sum + value + BTree(right).sum
      case Leaf(value) => value
    }
  }

  def avg:Double = {
    node match {
      case Branch(left,value,right) => (BTree(left).sum + value + BTree(right).sum).toDouble / BTree(node).size
      case Leaf(value) =>  value
    }
  }

  def find(param:Int):Option[Node]={
    node match {
      case Leaf(value) =>
        if(value==param){Some(node)}
        else{None}
      case Branch(left,value,right) =>
        if(value == param){Some(node)}
        else if (value < param){BTree(right).find(param)}
        else {BTree(left).find(param)}
    }
  }

}
