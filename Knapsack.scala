package com.practice

import scala.annotation.tailrec

object Knapsack extends App {

  @tailrec
  def sort(arr: Array[Int], i: Int, j: Int): Array[Int] = {
    if (j >= arr.length) return arr
    if (arr(i) < arr(j)) {
       sort(arr, i + 1, j + 1)
    } else {
      val temp = arr(i)
      arr(i) = arr(j)
      arr(j) = temp
      sort(arr, i+1, j+1)
    }
  }
  
  @tailrec
  def knapsack(values: Array[Int], weights: Array[Int], i: Int, limit: Int, maxValue: Int): Int = {
    if (limit == 0) {
      return maxValue
    }
    if (weights(i) <= limit) {
      knapsack(values, weights, i - 1, limit - weights(i), maxValue + values(i))
    } else {
      knapsack(values, weights, i - 1, limit - weights(i), maxValue)
    }
  }

  val values: Array[Int] = Array(120, 60, 100)
  val weights: Array[Int] = Array(30, 10, 20)
  val limit = 50
  val n = values.length - 1

  println(knapsack(sort(values,0,1), sort(weights,0,1), n, limit, 0))

}
