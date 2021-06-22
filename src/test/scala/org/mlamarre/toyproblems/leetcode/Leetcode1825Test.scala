package org.mlamarre.toyproblems.leetcode

import munit.FunSuite

class Leetcode1825Test extends FunSuite {

  import leetcode1825._

  test("1825. Finding MK Average".ignore) {
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