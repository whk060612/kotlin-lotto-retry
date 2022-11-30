package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.data.NOT_NUMBER
import lotto.exception.InputValidator

class InputView {

    private val inputValidator = InputValidator()
    fun readLottoMoney(): Int {
        val input = Console.readLine()
        if (inputValidator.checkInputInteger(input)) return input.toInt()
        throw IllegalArgumentException(NOT_NUMBER)
    }

    fun readWinNumbers(): List<Int> {
        val input = Console.readLine()
        val result = mutableListOf<Int>()
        for (number in input.split(",")) {
            if (inputValidator.checkInputInteger(number)) result.add(number.toInt())
            else throw IllegalArgumentException(NOT_NUMBER)
        }
        return result
    }

    fun readBonusNumber(): Int {
        val input = Console.readLine()
        if (!inputValidator.checkInputInteger(input)) throw IllegalArgumentException(NOT_NUMBER)
        return input.toInt()
    }
}