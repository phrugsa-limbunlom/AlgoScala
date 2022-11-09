package com.practice

import scala.annotation.tailrec

object TwoSum extends App {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val indices = Array[Int]()
    sumElement(nums, 0, nums.length - 1, target, indices)
  }

  @tailrec
  def sumElement(nums: Array[Int], i: Int, j: Int, target: Int, indices: Array[Int]): Array[Int] = {
    if (indices.length == 2) {
      return indices
    }
    if ((nums(i) + nums(j) == target) && i != j) {
      sumElement(nums, i, j, target, indices ++ Array(i, j))
    } else if (i != j) {
      sumElement(nums, i, j - 1, target, indices)
    } else {
      sumElement(nums, i + 1, nums.length - 1, target, indices)
    }
  }

  println(twoSum(Array(3,2,4), 6).mkString("Array(", ", ", ")"))
}
