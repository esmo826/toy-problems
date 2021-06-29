package org.elee.toyproblems.leetcode

import munit.FunSuite

class Leetcode1480Test extends FunSuite {

  // https://leetcode.com/problems/running-sum-of-1d-array/
  test("1480. Running Sum of 1d Array") {
    import leetcode1480.Solution._

    assertEquals(runningSum(Array(1, 2, 3)).toList, List(1, 3, 6))
    assertEquals(runningSum(Array(-3, 4, 101, 0)).toList, List(-3, 1, 102, 102))
  }

}
