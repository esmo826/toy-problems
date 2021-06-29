package org.elee.toyproblems.leetcode

package leetcode1700 {

  object Solution {
    import scala.collection.immutable.Queue

    @scala.annotation.tailrec
    def loopR(
        students: Queue[Int],
        sandwiches: Array[Int],
        idx: Int,
        numZeroStuds: Int,
        numOneStuds: Int
    ): Int = {
      if (idx >= sandwiches.size) students.size
      else if (sandwiches(idx) == 0 && numZeroStuds == 0) students.size
      else if (sandwiches(idx) == 1 && numOneStuds == 0) students.size
      else {
        val (current, qq) = students.dequeue
        if (current == sandwiches(idx)) {
          // We found a match! One less student with that preference
          if (current == 0) loopR(qq, sandwiches, idx + 1, numZeroStuds - 1, numOneStuds)
          else loopR(qq, sandwiches, idx + 1, numZeroStuds, numOneStuds - 1)
        } else {
          // No match, return the student to the back of the queue and leave the rest of the
          // data alone for the next iteration.
          loopR(qq :+ current, sandwiches, idx, numZeroStuds, numOneStuds)
        }
      }
    }

    def countStudents(students: Array[Int], sandwiches: Array[Int]): Int = {
      // Count the number of students w/ each preference ahead of time to improve our ability to
      // know when to stop the iteration. This allows us to avoid doing something like calling
      // contains() on the queue for each iteration to see if there are any students left who will
      // consume the current sandwich at the top of the "stack".
      val grouped = students.groupBy(identity).map { case (k, v) => (k, v.size) }
      loopR(
        Queue(students: _*),
        sandwiches,
        0,
        grouped.get(0).getOrElse(0),
        grouped.get(1).getOrElse(0)
      )
    }
  }
}
