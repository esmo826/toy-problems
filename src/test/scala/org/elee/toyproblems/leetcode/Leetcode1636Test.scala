package org.elee.toyproblems.leetcode

import munit.FunSuite

class Leetcode1636Test extends FunSuite {

  import leetcode1636.Solution

  test("1636. Sort Array by Increasing Frequency") {
    assertEquals(
      Solution.frequencySort(Array(1, 1, 2, 2, 2, 3)).toList,
      Array(3, 1, 1, 2, 2, 2).toList
    )
    assertEquals(Solution.frequencySort(Array(2, 3, 1, 3, 2)).toList, Array(1, 3, 3, 2, 2).toList)
    assertEquals(
      Solution.frequencySort(Array(-1, 1, -6, 4, 5, -6, 1, 4, 1)).toList,
      Array(5, -1, 4, 4, -6, -6, 1, 1, 1).toList
    )
  }

}
