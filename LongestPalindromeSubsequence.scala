package com.practice

object LongestPalindromeSubsequence extends App{
  def longestPalindromeSubseq(s: String): Int = {
    val array = new Array[Array[Int]](s.length)
    subsequence(0, s.length - 1, s, assignArray(0,0, array))
  }

  def assignArray(i : Int,j : Int, arr: Array[Array[Int]]) : Array[Array[Int]] = {
    if(i == arr.length-1 && j == arr.length-1){
      return arr
    }

    if(j == arr.length-1){
      assignArray(i, 0, arr)
    }else if(j < arr.length){
      assignArray(i, j+1, arr)
    }else if(i == arr.length-1){
      assignArray(0,j, arr)
    }else{
      assignArray(i+1, j, arr)
    }
  }

  def subsequence(i: Int, j: Int, s: String, array: Array[Array[Int]]): Int = {
    println(array(i)(j))
    if (i == j) {
      return 1
    }
    if (i > j) {
      return 0
    }

    if (s.charAt(i) == s.charAt(j)) {
      array(i)(j) = subsequence(i + 1, j - 1, s, array) + 2
      array(i)(j)
    } else {
      array(i)(j) = Math.max(subsequence(i + 1, j, s, array), subsequence(i, j - 1, s, array))
      array(i)(j)
    }
  }

  println(longestPalindromeSubseq("bbbab"))
}
