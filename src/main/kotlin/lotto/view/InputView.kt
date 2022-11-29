package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.data.ErrorMessage
import lotto.exception.InputValidator

class InputView {

    private val inputValidator = InputValidator()
    fun readLottoMoney(): Int {
        val input = Console.readLine()
        if (inputValidator.checkInputInteger(input)) return input.toInt()
        throw IllegalArgumentException(ErrorMessage.NOT_NUMBER.message)
    }

    fun readWinNumbers(): List<Int> {
        val input = Console.readLine()
        val result = mutableListOf<Int>()
        for (number in input.split(",")) {
            if (inputValidator.checkInputInteger(number)) result.add(number.toInt())
            else throw IllegalArgumentException(ErrorMessage.NOT_NUMBER.message)
        }
        return result
    }

    fun readBonusNumber(): Int {
        val input = Console.readLine()
        if (!inputValidator.checkInputInteger(input)) throw IllegalArgumentException(ErrorMessage.NOT_NUMBER.message)
        return input.toInt()
    }
}