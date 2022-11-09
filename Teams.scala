package com.practice

import scala.annotation.tailrec

object Teams extends App {
  def numTeams(rating: Array[Int]): Int = {
    buildTeam(0, 1, rating.length - 1, rating, 0)

  }

  @tailrec
  def buildTeam(i: Int, j: Int, k: Int, arr: Array[Int], count: Int): Int = {
    var countMember: Int = count
    val n: Int = arr.length
    if (i <= n - 1 && j <= n - 1 && k <= n - 1) {
      if ((arr(i) > arr(j) && arr(j) > arr(k)) || (arr(i) < arr(j) && arr(j) < arr(k))) {
        countMember = count + 1
      }
    }
    if (j < k) {
      buildTeam(i, j, k - 1, arr, countMember)
    }
    else if (j == k && j != n - 2) {
      buildTeam(i, j + 1, n - 1, arr, countMember)
    } else if (j == n - 2) {
      buildTeam(i + 1, i + 2, n - 1, arr, countMember)
    } else {
      count
    }
  }

  println(numTeams(Array(2, 5, 3, 4, 1)))
}
