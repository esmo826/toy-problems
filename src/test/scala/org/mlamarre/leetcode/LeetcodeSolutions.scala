package org.mlamarre.leetcode

import munit.FunSuite
import scala.annotation.tailrec

class LeetcodeSolutions extends FunSuite {
  test("1480. Running Sum of 1d Array") {
    // https://leetcode.com/problems/running-sum-of-1d-array/
    def runningSum(nums: Array[Int]): Array[Int] = {
        nums.foldLeft(List.empty[Int]){ case (acc, n) =>
            (acc.headOption.getOrElse(0) + n) :: acc
        }.reverse.toArray
    }

    assertEquals(runningSum(Array(1,2,3)).toList, List(1,3,6))
    assertEquals(runningSum(Array(-3, 4, 101, 0)).toList, List(-3, 1, 102, 102))
  }

  test("1. Two Sum") {
    // https://leetcode.com/problems/two-sum/
    @tailrec
    def loopR(tgt: Int, nums: Array[Int], i: Int, j: Int): Array[Int] = {
      if (j >= nums.size) loopR(tgt, nums, i + 1, i + 2)
      else if (nums(i) + nums(j) == tgt ) Array(i, j)
      else loopR(tgt, nums, i, j + 1)
    }

    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
      loopR(target, nums, 0, 1)
    }

    assertEquals(twoSum(Array(2,7,11,15), 9).toList, List(0,1))
    assertEquals(twoSum(Array(3,2,4), 6).toList, List(1,2))
    assertEquals(twoSum(Array(3,3), 6).toList, List(0,1))
    assertEquals(twoSum(Array(6, 10, 9, -3, 3), 3).toList, List(0,3))
  }

  test("1470. Shuffle the Array") {
    // https://leetcode.com/problems/shuffle-the-array/

    @tailrec
    def loopR(nums: Array[Int], i: Int, acc: List[Int]): Array[Int] = {
      if (i == nums.size / 2) acc.reverse.toArray
      else loopR(nums, i + 1, nums((nums.size/2)+i) :: nums(i) :: acc)
    }

    def shuffle(nums: Array[Int], n: Int): Array[Int] = {
      loopR(nums, 0, List.empty[Int])
    }

    assertEquals(shuffle(Array(2,5,1,3,4,7), 3).toList, List(2,3,5,4,1,7))
    assertEquals(shuffle(Array(1,2,3,4,4,3,2,1), 4).toList, List(1,4,2,3,3,2,4,1))
    assertEquals(shuffle(Array(1,1,2,2), 2).toList, List(1,2,1,2))
  }

  test("1825. Finding MK Average") {
    val mkaMaybe = MKAverage(3,1)
    assert(mkaMaybe.isRight)
    mkaMaybe.foreach{ mka =>
      mka.addElement(3)
      mka.addElement(1)
      assertEquals(mka.calculateMKAverage(), 2)
      mka.addElement(10)
      assertEquals(mka.calculateMKAverage(), 4)
      println("holeeeeeeee cow!")
    }
  }
}