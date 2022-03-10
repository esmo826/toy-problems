package org.elee.toyproblems.hackerrank
import scala.io.StdIn.readLine

// https://www.hackerrank.com/challenges/super-digit/problem
/*
We define super digit of an integer  using the following rules:
If  has only  digit, then its super digit is .
Otherwise, the super digit of  is equal to the super digit of the digit-sum of . Here, digit-sum of a number is defined as the sum of its digits.
*/
package superdigit {

  object Solution {

    // This is mapping each character into a long, which isn't memory efficient.
    def digitSumString(p: String): Long = {
        (p.toList.map(_.asDigit)).fold(0)(_+_).toLong
    }

    // This version only holds 2 longs in memory at a time.
    def digitSumString2(p: String): Long = {
        p.toList.foldLeft(0L)((acc, c) => acc + c.asDigit)
    }

    def digitSum(n: Long): Long = {
        // extracts the individual digits of a long into a list
        def extractDigits(n: Long, accum: List[Long]): List[Long] = {
            n match {
                case 0 => accum
                // Seems like there should be a better way to do this.
                case _ => n % 10L +: extractDigits(n / 10L, accum)
            }
        }
        extractDigits(n, List.empty).fold(0L)(_+_)
    }

    def superDigit(k: String, n: Int): Long = {
        // Reducing P to digitsum * n so we don't need to waste memory creating a giant string.
        val pReduced: Long = digitSumString2(k) * n
        // If a number is less than 10, P size == 1.
        if (pReduced < 10) pReduced
        else superDigit(digitSum(pReduced).toString, 1)
    }

    def main(args: Array[String]): Unit = {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
        val input = readLine()
        val parsedInputs = input.split(" ")
        val sd = superDigit(parsedInputs(0), parsedInputs(1).toInt)
        println(s"$sd")

    }

  }

}
