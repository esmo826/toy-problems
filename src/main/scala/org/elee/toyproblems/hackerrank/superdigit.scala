package org.elee.toyproblems.hackerrank
import scala.io.StdIn.readLine

// https://www.hackerrank.com/challenges/super-digit/problem
package superdigit {

  object Solution {

    def createPString(n: String, k: Int): String = {
        (0 until k).toList.foldLeft("")((acc, _) => acc + n )
    }

    def extractDigits(n: Long, accum: List[Long]): List[Long] = {
        n match {
            case 0 => accum
            case _ => n % 10L +: extractDigits(n / 10L, accum)
        }
    }

    def digitSum(p: String): String = {
        p.toList.map(x => Integer.parseInt(x.toString)).fold(0)(_+_).toString
    }

    def digitSum2(n: Long): Long = {
        extractDigits(n, List.empty).fold(0L)(_+_)
    }

    def superDigit(p: String, firstIter: Boolean): String = {

        val pSize = p.size

        if (firstIter)
            superDigit(digitSum(p), false)
        else {
            pSize match {
                case 0 => "0"
                case 1 => p
                case _ => superDigit(digitSum(p.dropRight(1)), false)
            }
        }
    }

    @scala.annotation.tailrec
    def superDigit2(n: Long): Long = {
        if (n < 10)
            n
        else superDigit2(digitSum2(n))
    }

    def superDigit3(k: String, n: Int): Long = {

        val pReduced: Long = digitSum(k).toLong * n

        if (pReduced < 10)
            pReduced
        else
            superDigit3(digitSum2(pReduced).toString, 1)
    }

    def main(args: Array[String]): Unit = {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
        val input = readLine()
        val parsedInputs = input.split(" ")
        //val pReduced = digitSum(parsedInputs(0).toLong).toInt * parsedInputs(1).toInt;
        //val sd = superDigit(createPString(parsedInputs(0), parsedInputs(1).toInt), true)
        //val sd = superDigit2(pReduced)
        val sd = superDigit3(parsedInputs(0), parsedInputs(1).toInt)
        println(s"$sd")

    }

  }

}
