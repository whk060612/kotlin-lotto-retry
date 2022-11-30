package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.data.BONUS_NUMBER_DUPLICATE
import lotto.data.LOTTO_NUMBER_RANGE_ILLEGAL
import lotto.data.NOT_NUMBER
import lotto.domain.Lotto
import lotto.domain.LottoMoney
import lotto.exception.InputValidator

class InputView {

    private val inputValidator = InputValidator()
    fun readLottoMoney(): LottoMoney {
        val input = Console.readLine()
        if (inputValidator.checkInputInteger(input)) return LottoMoney(input.toInt())
        throw IllegalArgumentException(NOT_NUMBER)
    }

    fun readWinNumbers(): Lotto {
        val input = Console.readLine()
        val numbers = mutableListOf<Int>()
        for (number in input.split(",")) {
            if (inputValidator.checkInputInteger(number)) numbers.add(number.toInt())
            else throw IllegalArgumentException(NOT_NUMBER)
        }
        return Lotto(numbers)
    }

    fun readBonusNumber(winLotto: Lotto): Int {
        val input = Console.readLine()
        if (!inputValidator.checkInputInteger(input)) throw IllegalArgumentException(NOT_NUMBER)
        val bonusNumber = input.toInt()
        if (!inputValidator.checkNumberRange(bonusNumber)) throw IllegalArgumentException(LOTTO_NUMBER_RANGE_ILLEGAL)
        if (inputValidator.checkBonusNumberDuplicate(
                bonusNumber,
                winLotto
            )
        ) throw IllegalArgumentException(BONUS_NUMBER_DUPLICATE)
        return bonusNumber
    }
}