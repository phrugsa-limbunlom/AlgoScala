package com.practice

import scala.annotation.tailrec

object LongestPalindrome extends App {
  def longestPalindrome(s: String): String = {
    val arr = findPalindrome(0, s.length - 1, s, new Array[Int](3))
    s.substring(arr(0), arr(1))
  }

  //  s = "baabad"
  def findPalindrome(i: Int, j: Int, s: String, arr: Array[Int]): Array[Int] = {
    if (i == j || j - i == 1) {
      return arr
    }

    if (s.charAt(i) == s.charAt(j)) {
      val c = findPalindrome(i + 1, j - 1, s, arr)
      findMax(c, findMax(findPalindrome(i + 1, j, s, arr), findPalindrome(i, j - 1, s, arr)))
    } else {
      findMax(findPalindrome(i + 1, j, s, arr), findPalindrome(i, j - 1, s, arr))
    }


  }

  def findMax(a: Array[Int], b: Array[Int]): Array[Int] = {
    if (a(1) - a(0) + 1 > b(1) - b(0) + 1) {
      a
    } else {
      b
    }
  }

  @tailrec
  def isPalindrome(s: String): Boolean = {
    if (s.length == 1) {
      return true
    }
    if (s.length == 2 && s.charAt(0) == s.charAt(1)) {
      return true
    }
    if (s.charAt(0) == s.charAt(s.length - 1)) {
      isPalindrome(s.substring(1, s.length - 1))
    } else {
      false
    }
  }

  println(longestPalindrome("aacabdkacaa"))
  println(longestPalindrome("v"))
}
