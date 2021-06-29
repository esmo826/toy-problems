package org.elee.toyproblems.leetcode

import munit.FunSuite

class Leetcode1700Test extends FunSuite {

  // https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
  test("1700. Number of Students Unable to Eat Lunch") {
    import leetcode1700.Solution._

    // Constraints are that both input arrays are the same size, and must have between 1 and 100
    // elements, and all elements must be either 0 or 1.
    assertEquals(countStudents(Array(1, 0), Array(0, 1)), 0)
    assertEquals(countStudents(Array(1, 1, 0), Array(0, 0, 0)), 2)
    assertEquals(countStudents(Array(1, 0, 1, 1), Array(0, 1, 0, 1)), 2) // ORDERING MATTERS!
    assertEquals(countStudents(Array(1, 0, 1, 1), Array(0, 1, 1, 0)), 1) // ORDERING MATTERS!
    assertEquals(countStudents(Array(1, 1, 0, 0), Array(0, 1, 0, 1)), 0)
    assertEquals(countStudents(Array(1, 1, 1, 0, 0, 1), Array(1, 0, 0, 0, 1, 1)), 3)
  }

}
