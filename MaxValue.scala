package com.practice

import scala.annotation.tailrec

object MaxValue extends App {


  @tailrec
  def findMax(array: Array[Int], i: Int, n: Int, max: Int): Int = {
    if (i == n) return max
    if (array(i) > max) findMax(array, i + 1, n, array(i))
    else findMax(array, i + 1, n, max)
  }

  val arr: Array[Int] = Array(1, 5, 8, 10, 3, 119)

  println(findMax(arr, 0, arr.length, Int.MinValue))

}
