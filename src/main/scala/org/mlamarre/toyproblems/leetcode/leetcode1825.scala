package org.mlamarre.toyproblems.leetcode

/**
  * You are given two integers, m and k, and a stream of integers. You are tasked to implement a
  * data structure that calculates the MKAverage for the stream.
  *
  * The MKAverage can be calculated using these steps:
  *
  * 1. If the number of the elements in the stream is less than m you should consider the MKAverage
  *    to be -1. Otherwise, copy the last m elements of the stream to a separate container.
  * 2. Remove the smallest k elements and the largest k elements from the container.
  * 3. Calculate the average value for the rest of the elements rounded down to the nearest integer.
  *
  * Implement the MKAverage class:
  *
  * - MKAverage(int m, int k) Initializes the MKAverage object with an empty stream and the two
  *   integers m and k.
  * - void addElement(int num) Inserts a new element num into the stream.
  * - int calculateMKAverage() Calculates and returns the MKAverage for the current stream rounded
  *   down to the nearest integer.
  *
  * Constraints:
  *   3 <= m < 10^5
  *   1 <= k*2 < m
  *   1 <= num < 10^5
  *
  * Difficulty: hard
  * https://leetcode.com/problems/finding-mk-average/
  */
package leetcode1825 {
  /**
  * Your MKAverage object will be instantiated and called as such:
  * var obj = new MKAverage(m, k)
  * obj.addElement(num)
  * var param_2 = obj.calculateMKAverage()
  */

  /**
    *
  * @param _m
  * @param _k
  */
  class MKAverage(_m: Int, _k: Int) {

    // We are constrained by the class definition that we were given by Leetcode such that it doesn't
    // naturally support a pure FP API. So we encapsulate it here in private state. In a fully pure
    // FP program, the API for this class would look more like MKAveragePure's API.
    private var s: MkaState = MKAveragePure(List.empty[Int])

    def addElement(num: Int) {
      s = s.add(num)._2
    }

    def calculateMKAverage(): Int = {
      val result = s.calculate(_m, _k)
      s = result._2
      result._1
    }

  }

  trait MkaState {
    def add(n: Int): (Unit, MkaState)
    def calculate(m: Int, k: Int): (Int, MkaState)
  }

  final case class MKAveragePure(data: List[Int]) extends MkaState { self =>

    override def add(n: Int): (Unit, MkaState) = ((), MKAveragePure(n :: data))

    override def calculate(m: Int, k: Int): (Int, MkaState) = {
      // bogus calculation for now, just to see how things shake out
      ((data.fold(0)(_+_) / data.size), self)
    }
    // def addElement(num: Int): Unit = ???
    // def calculateMKAverage(): Int = ???
  }

  object MKAverage {
    private val MIN_M = 3
    private val MAX_M = 100000
    private val MIN_K = 1
    private val MIN_NUM = 1

    def apply(m: Int, k: Int): Either[Throwable, MKAverage] = {
      if ((m < MIN_M) || (m > MAX_M)) Left(new IllegalArgumentException(s"Invalid value for m: $m"))
      else if ((k * 2 < MIN_K) || (k * 2 ) >= m) Left(new IllegalArgumentException(s"Invalid value for k: $k"))
      else Right(new MKAverage(m,k))
    }
  }


//------------------

  // class MKA2(_m: Int, _k: Int) {
  //   import cats.data.State

  //   // We are constrained by the class definition that we were given by Leetcode such that it doesn't
  //   // naturally support a pure FP API. So we encapsulate it here in private state. In a fully pure
  //   // FP program, the API for this class would look more like MKAveragePure's API.
  //   private var xs = List.empty[Int]

  //   def addElement(num: Int) {
  //     xs = add(num).run(xs).value._1
  //   }

  //   def calculateMKAverage(): Int = {
  //     val result = calc(_m, _k).run(xs).value
  //     xs = result._1
  //     result._2
  //   }

  //   private def add(n: Int): State[List[Int], Unit] = State(xs => (n :: xs, ()))
  //   private def calc(m: Int, k:Int): State[List[Int], Int] =
  //     // TODO: Eventually use m and k to calculate the MK Average, but for nwo just do a simple average until we sort out the types
  //     State(xs => (xs, (xs.fold(0)(_+_) / xs.size)))

  // //---------------
  //   private val ys = scala.collection.mutable.ListBuffer.empty[Int]

  //   def addElement2(num: Int) {
  //     ys.addOne(num)
  //   }

  //   def calculateMKAverage2(): Int = {
  //     val result = (ys.fold(0)(_+_) / ys.size)
  //     ys.dropInPlace(1)
  //     result
  //   }

  // }

  // final case class MKAverageCats(data: List[Int]) {
  //   import cats.data.State

  //   // type Foo[A] = State[List[Int], A]  // TODO: So then is the state really a Foo?

  //   // We are constrained by the class definition that we were given by Leetcode such that it doesn't
  //   // naturally support a pure FP API. So we encapsulate it here in private state. In a fully pure
  //   // FP program, the API for this class would look more like MKAveragePure's API.
  //   private var s = State.set(List.empty[Int])

  //   def add(n: Int): State[List[Int], Unit] = State(xs => (n :: xs, ()))
  //   def calc(m: Int, k:Int): State[List[Int], Int] =
  //     // TODO: Eventually use m and k to calculate the MK Average, and the state value will be updated, but for now just do a simple average until we sort out the types
  //     State(xs => (xs, (xs.fold(0)(_+_) / xs.size)))

  //   // def addElement(num: Int): MKAverageCats = {
  //   //   val foo = addImpl(num).run(data).value
  //   //   MKAverageCats(foo._1)
  //   // }

  //   // def calculateMKAverage(): Int = {
  //   //   val (newState, result) = calc().run(s)
  //   //   val foo = s.run(List.empty[Int])
  //   //   // state is unchanged here, so no need to update it
  //   //   s.calculate(_m, _k)._1
  //   // }

  // }


}