package org.elee.toyproblems.hackerrank
import munit.FunSuite

class PasswordCrackerTest extends FunSuite {

  test("sample input 0") {
    import PasswordCracker.Solution._

    assertEquals(extractPasswordComponents(List("because", "can", "do", "must", "we", "what"), "wedowhatwemustbecausewecan", List.empty),
    List("we", "do", "what", "we", "must", "because", "we", "can"))

    assertEquals(extractPasswordComponents(List("hello", "planet"), "helloworld", List.empty),
    List.empty)

    assertEquals(extractPasswordComponents(List("ab", "abcd", "cd"), "abcd", List.empty),
    List("ab", "cd"))
  }

  test("sample input 1") {
    import PasswordCracker.Solution._

    assertEquals(extractPasswordComponents(List("ozkxyhkcst", "xvglh", "hpdnb", "zfzahm"), "zfzahm", List.empty),
    List("zfzahm"))

    assertEquals(extractPasswordComponents(List("gurwgrb", "maqz", "holpkhqx", "aowypvopu"), "gurwgrb", List.empty),
    List("gurwgrb"))

    assertEquals(extractPasswordComponents(List("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"),
    "aaaaaaaaaab", List.empty),
    List.empty)
  }

}