package org.elee.toyproblems.hackerrank
import munit.FunSuite

class jumpingbunniesTest extends FunSuite {

  test("gcd") {
    import jumpingbunnies.Solution._

    assertEquals(gcd(54L,24L), 6L)
    assertEquals(gcd(48L,18L), 6L)
  }

  test("lcm: case 0") {
    import jumpingbunnies.Solution._
    assertEquals(lcm(List(2, 3, 4)), 12L)
  }

  test("lcm: case 3") {
    import jumpingbunnies.Solution._
    assertEquals(lcm(List(83, 75, 60, 37, 10, 26, 98, 15, 13, 22)), 6455549100L)
  }

  test("lcm: case 5") {
    import jumpingbunnies.Solution._
    assertEquals(lcm(List(597, 322, 187, 734, 498, 215, 176, 451, 114, 204)), 1467174839068147440L)
  }

  test("lcm: case 10") {
    import jumpingbunnies.Solution._
    assertEquals(lcm(List(1, 3)), 3L)
  }

}