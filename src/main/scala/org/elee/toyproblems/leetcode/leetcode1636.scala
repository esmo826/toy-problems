package org.elee.toyproblems.leetcode

/** Given an array of integers nums, sort the array in increasing order based on the frequency of
  * the values. If multiple values have the same frequency, sort them in decreasing order.
  *
  * Return the sorted array.
  *
  * https://leetcode.com/problems/sort-array-by-increasing-frequency/
  *
  * Difficulty: easy
  */
package leetcode1636 {

  object Solution {
    private def sortFn(x: (Int, Array[Int]), y: (Int, Array[Int])): Boolean =
      if (x._2.size == y._2.size) x._1 > y._1 else x._2.size < y._2.size

    def frequencySort(nums: Array[Int]): Array[Int] = {
      nums.groupBy(identity).toList.sortWith(sortFn).flatMap(_._2).toArray
    }
  }
}
