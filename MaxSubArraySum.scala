package com.practice

import scala.annotation.tailrec

object MaxSubArraySum extends App{
  @tailrec
  def maxSubArraySum(i: Int, currentMax: Int, maxAsOf: Int, array: Array[Int]): Int = {
    if (i == array.length - 1) {
      maxAsOf
    } else {
      if (currentMax + array(i) > 0) {
        maxSubArraySum(i + 1, currentMax+ array(i), Math.max(currentMax + array(i), maxAsOf), array)
      } else {
        maxSubArraySum(i + 1, 0, maxAsOf, array)
      }
    }
  }

  println(maxSubArraySum(0,0,-1,Array(-2,-3,4,-1,-2,1,5,-3)))
}
