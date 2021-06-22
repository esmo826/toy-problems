package org.mlamarre.toyproblems.leetcode

/** Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
  *
  * There is a cycle in a linked list if there is some node in the list that can be reached again by
  * continuously following the next pointer. Internally, pos is used to denote the index of the node
  * that tail's next pointer is connected to. Note that pos is not passed as a parameter.
  *
  * Notice that you should not modify the linked list.
  *
  * Difficulty: medium https://leetcode.com/problems/linked-list-cycle-ii/
  *
  * Just to editorialize a bit: F-ing GROSS. NULL?! Who in their right mind ever types that four
  * letter word in actual Scala code?!
  */
package leetcode0142 {

  object Solution {

    /** Definition for singly-linked list.
      */
    class ListNode(var _x: Int = 0) {
      var next: ListNode = null
      var x: Int         = _x
    }

    def detectCycle(head: ListNode): ListNode = {
      ???
    }
  }

}
