package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.exception.Validator

class InputView {

    private val validator = Validator()

    fun readBuyMoney(): Int {
        val input = Console.readLine()
        return validator.checkBuyMoney(input)
    }
}