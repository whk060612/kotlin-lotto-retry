package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.data.ErrorMessage
import lotto.exception.InputValidator
import lotto.exception.WinningNumbersValidator

class InputView {

    private val inputValidator = InputValidator()
    fun readBuyMoney(): Int {
        val input = Console.readLine()
        if (inputValidator.checkInputInteger(input)) return input.toInt()
        else throw IllegalArgumentException(ErrorMessage.NOT_NUMBER.message)
    }

    fun readWinningNumbers() {
        val input = Console.readLine()
        val winningNumbersValidator = WinningNumbersValidator()
    }
}