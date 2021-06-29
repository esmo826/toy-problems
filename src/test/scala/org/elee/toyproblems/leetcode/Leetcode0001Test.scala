package org.elee.toyproblems.leetcode

import munit.FunSuite

class Leetcode0001Test extends FunSuite {

  // https://leetcode.com/problems/two-sum/
  test("1. Two Sum") {
    import leetcode0001.Solution._

    assertEquals(twoSum(Array(2, 7, 11, 15), 9).toList, List(0, 1))
    assertEquals(twoSum(Array(3, 2, 4), 6).toList, List(1, 2))
    assertEquals(twoSum(Array(3, 3), 6).toList, List(0, 1))
    assertEquals(twoSum(Array(6, 10, 9, -3, 3), 3).toList, List(0, 3))
  }

}
