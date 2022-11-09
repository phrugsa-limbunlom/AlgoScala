package com.practice

import scala.annotation.tailrec

object MedianSearch extends App {
  @tailrec
  def medianSearch(start: Int, end: Int, array: Array[Int], find: Int): Boolean = {
    val mid: Int = (start + end) / 2
    if(start > end){
      return false
    }
    if (find == array(mid)) {
      true
    } else if (find < array(mid)) {
      medianSearch(start, mid - 1, array, find)
    } else {
      medianSearch(mid + 1, end, array, find)
    }
  }

  println(medianSearch(0, 7, Array(0,2,5,7,8,9,10),-1))
}
