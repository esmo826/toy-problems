package org.elee.toyproblems.hackerrank
import scala.io.StdIn.readLine

// https://www.hackerrank.com/challenges/password-cracker-fp
package PasswordCracker {

    object Solution {

        def isValidAttempt(knownPasswords: List[String], loginAttempt: String): Boolean = {
            knownPasswords.fold(loginAttempt){ (acc, pw) =>
                acc.replaceAll(pw, "")
            }.isEmpty
        }

        def extractPasswordComponents(knownPasswords: List[String], loginAttempt: String, accum: List[String]): List[String] = {

            def extractNextPassword(newAttempt:String): Option[String] = {
                knownPasswords.collectFirst {
                    case x if (newAttempt.startsWith(x)) => x
                }
            }

            loginAttempt match {
                case "" => accum
                case attempt => {
                    val nextPw = extractNextPassword(attempt)
                    nextPw.fold(List.empty[String]){ nPw =>
                        extractPasswordComponents(knownPasswords, attempt.subSequence(nPw.size, attempt.size).toString, accum :+ nPw)
                    }
                }
            }
        }

        def main(args: Array[String]): Unit = {

            def runTestCase(testCase: Int): String = {
                val knownPwCount = readLine().toInt
                val knownPasswords = readLine().split(" ").toList
                val loginAttempt = readLine()

                //println("Known passwords" + knownPasswords)
                //println("loginAttempt" + loginAttempt)
                val results = extractPasswordComponents(knownPasswords, loginAttempt, List.empty)
                //println("Running test case" + testCase)
                if (results.isEmpty)
                    "WRONG PASSWORD"
                else
                    results.mkString(" ")

            }

            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
            val testCaseCount = readLine().toInt

            val outputs = for {
                i <- 0 until testCaseCount
            } yield runTestCase(i)

            outputs.toList.foreach(println)
        }
    }
}
