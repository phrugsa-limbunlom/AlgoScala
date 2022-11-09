package com.practice

import scala.annotation.tailrec

object CoinChange extends App {

  def collectCoins(coins: Array[Int], c: Array[Int]): Array[Int] = {
    if (c(0) == 0) {
      return coins
    }
    coins ++ c
  }

  @tailrec
  def coinChange(array: Array[Int], i: Int, amount: Int, coins: Array[Int]): Array[Int] = {
    if (amount == 0) return collectCoins(coins, Array(0))
    if (amount > 0 && array(i) <= amount) {
      coinChange(array, i, amount - array(i), collectCoins(coins, Array(array(i))))
    } else {
      coinChange(array, i - 1, amount, coins)
    }
  }

  val changes: Array[Int] = Array(2, 3, 5, 10, 20, 30, 50)

  println(coinChange(changes, changes.length - 1, 78, Array(0)).mkString("Array(", ", ", ")"))
  println(coinChange(changes, changes.length - 1, 100, Array(0)).mkString("Array(", ", ", ")"))

}
