package com.github.tamaki.study.yoda.btree

/**
 * Created by yohei.oda on 2015/06/25.
 */
trait Node

case class Branch(left:Node, value: Int, right: Node) extends Node

case class Leaf(value:Int) extends Node

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

  def avg:Int = {
    node match {
      case Branch(left,value,right) => (BTree(left).sum + value + BTree(right).sum) / BTree(node).size
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
