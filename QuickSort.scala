package com.practice

object QuickSort extends App {

  def swap(m: Int, n: Int, arr: Array[Int]): Unit = {
    val temp: Int = arr(n)
    arr(n) = arr(m)
    arr(m) = temp
  }

  def partition(low: Int, high: Int, pivot: Int, arr: Array[Int]): Int = {
    var i = low - 1: Int
    arr.zipWithIndex.foreach(n => {
      if (n._2 >= low && n._2 < high) {
        if (n._1 < pivot) {
          i = i + 1
          swap(i, n._2, arr)
        }
      }
    })
    i = i + 1
    swap(i, high, arr)
    i
  }

  def sort(low: Int, high: Int, array: Array[Int]): Array[Int] = {
    if (low < high) {
      val pi = partition(low, high, array(high), array)
      sort(low, pi - 1, array)
      sort(pi + 1, high, array)
    }
    array
  }

  val arr: Array[Int] = Array(8, 7, 2, 1, 0, 9, 6)
  println(sort(0, arr.length - 1, arr).mkString("Array(", ", ", ")"))
}
