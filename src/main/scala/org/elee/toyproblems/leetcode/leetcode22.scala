package leetcode22 {

    object Solution {

        def genParens(n: Int, paren: String) = (0 until n).map(_ => paren).toList
        def genLeftParens(n: Int) = genParens(n, "(")
        def genRightParens(n: Int) = genParens(n, ")")

        def isValid(parensCombo: List[String]) : Boolean = {
            val calculated = parensCombo.map { p =>
                p match {
                    case "(" => 1
                    case ")" => -1
                }
            }
            // Accumulate the sum of the calculated list
            // As we are, it is invalid
            val sum = calculated.foldLeft(0)((accum, value) => {
                if ((accum + value) < 0) accum else (accum + value)
            })
            //println("SUM: " + sum)
            sum == 0
        }
        def genValidP(accum: List[String], leftParens: List[String], rightParens: List[String]): List[String] = {
            val allCombos = (leftParens ++ rightParens).permutations.toList
            // filter out the invalid combinations
            val validCombos = allCombos.filter(isValid)
            println("validCombos: " + validCombos)
            val validComboStrings = validCombos.map(_.mkString)
            validComboStrings
        }

        def generateParenthesis(n: Int): List[String] = {
            genValidP(List.empty, genLeftParens(n), genRightParens(n))
        }
    }
}
