package org.elee.toyproblems.leetcode

package leetcode1470 {

  object Solution {
    @scala.annotation.tailrec
    def loopR(nums: Array[Int], i: Int, acc: List[Int]): Array[Int] = {
      if (i == nums.size / 2) acc.reverse.toArray
      else loopR(nums, i + 1, nums((nums.size / 2) + i) :: nums(i) :: acc)
    }

    def shuffle(nums: Array[Int], n: Int): Array[Int] = {
      loopR(nums, 0, List.empty[Int])
    }
  }

}
