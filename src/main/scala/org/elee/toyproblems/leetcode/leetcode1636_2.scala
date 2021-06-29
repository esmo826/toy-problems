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
package leetcode1636_2 {

  object Solution {

    def frequencySort(nums: Array[Int]): Array[Int] = {

      //nums.groupBy(identity).toList.sortBy(t => (t._2.size, t._1)).flatMap(_._2).toArray
      //nums.groupBy(identity).toList.sortBy(t => t._2.size).groupBy(_._2.size).values.toList.flatten.reverse.flatMap(_._2).toArray
      //nums.groupBy(identity).toList.sortBy(t => (t._2.size)).groupBy(_._2.size).toList.reverse.flatMap(l => if (l._2.size > 1) l._2.sortBy(_._1).reverse.flatMap(_._2) else l._2.flatMap(_._2)).toArray
      //nums.groupBy(identity).toList.sortBy(t => (t._2.size)).groupBy(_._2.size).map { case (k, v) => if (v.size > 1) v.sortBy(_._1).reverse else v }.toList.sortBy(l => l.size).flatten.map(_._2).flatten.toArray

      // this solves the last example
      //nums.groupBy(identity).toList.sortBy(t => (t._2.size)).groupBy(_._2.size).map{ case (k, v) => if (v.size > 1) v.sortBy(_._1).reverse else v }.toList.sortBy(l => l.size).reverse.flatMap(_.map(_._2)).flatten.toArray

      val groupsByIncreasingFrequency = nums.groupBy(identity).toList.groupBy(t => t._2.size).toList.sortBy(_._1)

      // if the values have multiple entries, sort them in decending order
      groupsByIncreasingFrequency.map{ case (k,v) => if (v.size > 1) v.sortBy(_._1).reverse.flatMap(_._2) else v.flatMap(_._2) }.flatten.toArray
    }
  }
}