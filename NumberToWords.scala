package com.practice

object NumberToWords extends App {
  val arr1 = Array("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")
  val arr2 = Array("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
    "sixteen", "seventeen", "eighteen", "nineteen")
  val billions = 1000000000
  val millions = 1000000
  val thousands = 100000
  val hundreds = 100


  def numberToWords(num: Int): String = {
       convertNumberToWord(num,"")
  }

  def convertNumberToWord(num: Int, s: String): String = {
    if(num == 0){
      return s
    }
    if (num >= billions) {
      s.concat(convertNumberToWord(num / billions, s) + " billion " + convertNumberToWord(num % billions, s))
    } else if (num >= millions) {
      s.concat(convertNumberToWord(num / millions, s) + " million " + convertNumberToWord(num % millions, s))
    } else if (num >= thousands) {
      s.concat(convertNumberToWord(num / thousands, s) + " thousand " + convertNumberToWord(num % thousands, s))
    } else if (num >= hundreds) {
      s.concat(convertNumberToWord(num / hundreds, s) + " hundred " + convertNumberToWord(num % hundreds, s))
    } else if (num >= 20) {
      s.concat(arr1(num / 10 - 1).concat(" " + convertNumberToWord(num % 10, s)))
    }
    else {
      s.concat(arr2(num - 1))
    }
  }

  println(numberToWords(100))
}