package org.mlamarre.toyproblems.leetcode

import munit.FunSuite
import scala.annotation.tailrec
import scala.collection.immutable.Queue

/**
 * Tests that exercise a variety of solutions to some random questions from leetcode.com.
 * The solution templates there are painfully derived from languages that most commonly use arrays
 * and vectors, hence the prevalence of Array instead of the more Scala-idiomatic List.
 */
class LeetcodeSolutions extends FunSuite {
  test("1. Two Sum") {
    // https://leetcode.com/problems/two-sum/
    @tailrec
    def loopR(tgt: Int, nums: Array[Int], i: Int, j: Int): Array[Int] = {
      if (j >= nums.size) loopR(tgt, nums, i + 1, i + 2)
      else if (nums(i) + nums(j) == tgt ) Array(i, j)
      else loopR(tgt, nums, i, j + 1)
    }

    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
      loopR(target, nums, 0, 1)
    }

    assertEquals(twoSum(Array(2,7,11,15), 9).toList, List(0,1))
    assertEquals(twoSum(Array(3,2,4), 6).toList, List(1,2))
    assertEquals(twoSum(Array(3,3), 6).toList, List(0,1))
    assertEquals(twoSum(Array(6, 10, 9, -3, 3), 3).toList, List(0,3))
  }

  test("1470. Shuffle the Array") {
    // https://leetcode.com/problems/shuffle-the-array/

    @tailrec
    def loopR(nums: Array[Int], i: Int, acc: List[Int]): Array[Int] = {
      if (i == nums.size / 2) acc.reverse.toArray
      else loopR(nums, i + 1, nums((nums.size/2)+i) :: nums(i) :: acc)
    }

    def shuffle(nums: Array[Int], n: Int): Array[Int] = {
      loopR(nums, 0, List.empty[Int])
    }

    assertEquals(shuffle(Array(2,5,1,3,4,7), 3).toList, List(2,3,5,4,1,7))
    assertEquals(shuffle(Array(1,2,3,4,4,3,2,1), 4).toList, List(1,4,2,3,3,2,4,1))
    assertEquals(shuffle(Array(1,1,2,2), 2).toList, List(1,2,1,2))
  }

  test("1480. Running Sum of 1d Array") {
    // https://leetcode.com/problems/running-sum-of-1d-array/
    def runningSum(nums: Array[Int]): Array[Int] = {
        nums.foldLeft(List.empty[Int]){ case (acc, n) =>
            (acc.headOption.getOrElse(0) + n) :: acc
        }.reverse.toArray
    }

    assertEquals(runningSum(Array(1,2,3)).toList, List(1,3,6))
    assertEquals(runningSum(Array(-3, 4, 101, 0)).toList, List(-3, 1, 102, 102))
  }

  test("1700. Number of Students Unable to Eat Lunch") {
    // https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

    @tailrec
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
      val grouped = students.groupBy(identity).map{ case (k,v) => (k, v.size)}
      loopR(Queue(students: _*), sandwiches, 0, grouped.get(0).getOrElse(0), grouped.get(1).getOrElse(0))
    }

    // Constraints are that both input arrays are the same size, and must have between 1 and 100
    // elements, and all elements must be either 0 or 1.
    assertEquals(countStudents(Array(1,0), Array(0,1)), 0)
    assertEquals(countStudents(Array(1,1,0), Array(0,0,0)), 2)
    assertEquals(countStudents(Array(1,0,1,1), Array(0,1,0,1)), 2)  // ORDERING MATTERS!
    assertEquals(countStudents(Array(1,0,1,1), Array(0,1,1,0)), 1)  // ORDERING MATTERS!
    assertEquals(countStudents(Array(1,1,0,0), Array(0,1,0,1)), 0)
    assertEquals(countStudents(Array(1,1,1,0,0,1), Array(1,0,0,0,1,1)), 3)
  }

  // test("1825. Finding MK Average") {
    // val mkaMaybe = MKAverage(3,1)
    // assert(mkaMaybe.isRight)
    // mkaMaybe.foreach{ mka =>
      // mka.addElement(3)
      // mka.addElement(1)
      // assertEquals(mka.calculateMKAverage(), 2)
      // mka.addElement(10)
      // assertEquals(mka.calculateMKAverage(), 4)
      // println("holeeeeeeee cow!")
    // }
  // }
}
