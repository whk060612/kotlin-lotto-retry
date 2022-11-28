package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.exception.BuyMoneyValidator
import lotto.exception.WinningNumbersValidator

class InputView {

    fun readBuyMoney(): Int {
        val input = Console.readLine()
        val buyMoneyValidator = BuyMoneyValidator()
        return buyMoneyValidator.checkBuyMoney(input)
    }
}