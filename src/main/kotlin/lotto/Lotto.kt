package lotto

import lotto.data.ErrorMessage.*
import lotto.data.LOTTO_NUMBER_COUNT

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_COUNT_ILLEGAL.message }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_DUPLICATE_ILLEGAL.message }
    }

    fun countCorrectNumber(winNumber: List<Int>): Int {
        var count = 0
        for (number in numbers) {
            if (winNumber.contains(number)) count += 1
        }
        return count
    }

    fun checkBonusNumberCorrect(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }
}
