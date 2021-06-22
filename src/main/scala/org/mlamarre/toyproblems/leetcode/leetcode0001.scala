package org.mlamarre.toyproblems.leetcode

// https://leetcode.com/problems/two-sum/
package leetcode0001 {

  object Solution {
    @scala.annotation.tailrec
    def loopR(tgt: Int, nums: Array[Int], i: Int, j: Int): Array[Int] = {
      if (j >= nums.size) loopR(tgt, nums, i + 1, i + 2)
      else if (nums(i) + nums(j) == tgt) Array(i, j)
      else loopR(tgt, nums, i, j + 1)
    }

    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
      loopR(target, nums, 0, 1)
    }
  }

}
