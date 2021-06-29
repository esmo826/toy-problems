package org.elee.toyproblems.leetcode

import munit.FunSuite

class Leetcode22Test extends FunSuite {

  // https://leetcode.com/problems/generate-parentheses/
  test("1. Generate Parentheses") {
    import leetcode22.Solution._

    //println(generateParenthesis(2))
    assertEquals(generateParenthesis(1), List("()"))
    assertEquals(generateParenthesis(2), List("(())", "()()"))
    assertEquals(generateParenthesis(3), List("((()))","(()())","(())()","()(())","()()()"))
  }

}