package org.elee.toyproblems.leetcode

package leetcode1480 {

  object Solution {
    def runningSum(nums: Array[Int]): Array[Int] = {
      nums
        .foldLeft(List.empty[Int]) { case (acc, n) => (acc.headOption.getOrElse(0) + n) :: acc }
        .reverse
        .toArray
    }
  }
}
