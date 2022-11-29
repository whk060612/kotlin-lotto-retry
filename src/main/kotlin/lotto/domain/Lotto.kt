package lotto.domain

import lotto.data.ErrorMessage
import lotto.data.LOTTO_NUMBER_COUNT
import lotto.data.MAXIMUM_LOTTO_NUMBER
import lotto.data.MINIMUM_LOTTO_NUMBER

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { ErrorMessage.LOTTO_NUMBER_COUNT_ILLEGAL.message }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { ErrorMessage.LOTTO_NUMBER_DUPLICATE_ILLEGAL.message }
        require(checkLottoNumberRange()) { ErrorMessage.LOTTO_NUMBER_RANGE_ILLEGAL.message }
    }

    private fun checkLottoNumberRange(): Boolean {
        for (number in numbers) {
            if ((number < MINIMUM_LOTTO_NUMBER) or (number > MAXIMUM_LOTTO_NUMBER)) return false
        }
        return true
    }

    fun countCorrectNumber(winNumber: Lotto): Int {
        var count = 0
        for (number in numbers) {
            if (winNumber.getNumbers().contains(number)) count += 1
        }
        return count
    }

    fun checkBonusNumberCorrect(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }

    fun checkBonusNumberDuplicate(bonusNumber: Int): Boolean {
        if (numbers.contains(bonusNumber)) return true
        return false
    }
}
