package org.elee.toyproblems.hackerrank
import scala.io.StdIn.readLine

package jumpingbunnies {

  object Solution {
    @scala.annotation.tailrec
    // Euclidean algorithm (https://en.wikipedia.org/wiki/Greatest_common_divisor)
    def gcd(a: Long, b: Long):Long = {
        if (b == 0) a.abs else gcd(b, a % b)
    }
    def lcm(values: List[Long]) = values.foldLeft(1L) { (a,b) =>
        // don't understand why a * b / gcd(a,b) doesn't work
        // turns out that if you do the multiplication of a*b first, for large datasets/numbers, this can overflow
        a / gcd(a,b) * b
    }

    def main(args: Array[String]): Unit = {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
        val a = readLine()
        val b = readLine()

        //println(s"Number of bunnies: $a Jumps: $b")

        val numberOfJumps = a.toLongOption.map { numberOfBunnies =>
            val jumpsList = b.split(" ").toList.map(_.toLongOption).flatten
            if (numberOfBunnies == jumpsList.size)
                lcm(jumpsList)
            else
                throw new IllegalArgumentException("Invalid inputs")

        }.getOrElse(0)
        println(s"$numberOfJumps")
    }
  }

}