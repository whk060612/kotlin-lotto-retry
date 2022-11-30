package lotto.domain

import lotto.data.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_COUNT_ILLEGAL }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_DUPLICATE_ILLEGAL }
        require(checkLottoNumberRange()) { LOTTO_NUMBER_RANGE_ILLEGAL }
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
