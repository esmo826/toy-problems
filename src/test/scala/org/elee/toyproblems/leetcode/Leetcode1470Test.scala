package org.elee.toyproblems.leetcode

import munit.FunSuite

class Leetcode1470Test extends FunSuite {

  // https://leetcode.com/problems/shuffle-the-array/
  test("1470. Shuffle the Array") {
    import leetcode1470.Solution._

    assertEquals(shuffle(Array(2, 5, 1, 3, 4, 7), 3).toList, List(2, 3, 5, 4, 1, 7))
    assertEquals(shuffle(Array(1, 2, 3, 4, 4, 3, 2, 1), 4).toList, List(1, 4, 2, 3, 3, 2, 4, 1))
    assertEquals(shuffle(Array(1, 1, 2, 2), 2).toList, List(1, 2, 1, 2))
  }

}
