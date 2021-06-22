package org.mlamarre.toyproblems.leetcode

import munit.FunSuite

class Leetcode0142Test extends FunSuite {

  import leetcode0142.Solution._

  // The design of ListNode provided by leetcode is absolutely disgusting and not at all idiomatic
  // Scala code. Hence, these disgusting null values to indicate an empty list...
  object ListBuilder {

    /** Turns a perfectly good List[Int] into a disgusting linked list made of ListNode objects. If
      * xs is empty, null is returned. /barf
      *
      * @param xs
      *   @param pos
      * @return
      */
    def mkList(xs: List[Int], pos: Int): ListNode = {
      if (xs.isEmpty || pos >= xs.size) null
      else {
        val nodes = xs.map(x => new ListNode(x))

        // Link all the nodes together
        nodes.reduceLeft { (x, y) =>
          x.next = y
          y
        }

        // Create the cycle, if requested
        if (pos >= 0) nodes(nodes.size - 1).next = nodes(pos)

        nodes(0)
      }
    }
  }

  test("Gross testing of this disgusting ListNode class") {
    val list1 = ListBuilder.mkList(List(1, 5, 9), 1)
    assertEquals(list1.x, 1)
    assertEquals(list1.next.x, 5)
    assertEquals(list1.next.next.x, 9)
    assertEquals(list1.next.next.next.x, 5)

    assert(ListBuilder.mkList(List(1, 99), -1).next.next == null)

    assert(ListBuilder.mkList(Nil, 0) == null)
  }

  // https://leetcode.com/problems/linked-list-cycle-ii/
  test("142. Linked List Cycle II") {
    val xs = ListBuilder.mkList(List(1, 5, 9), 1)

    val cycleStart = detectCycle(xs)
    assertEquals(cycleStart.x, xs.next.x)
  }
}
