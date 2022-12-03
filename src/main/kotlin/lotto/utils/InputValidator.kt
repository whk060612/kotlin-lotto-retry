package lotto.utils

import lotto.domain.Lotto

/* 입력에서 생기는 예외 검사 */

class InputValidator {
    fun checkInputInteger(input: String): Boolean {
        input.toIntOrNull() ?: return false
        return true
    }

    fun checkNumberRange(number: Int): Boolean {
        if ((number < MINIMUM_LOTTO_NUMBER) or (number > MAXIMUM_LOTTO_NUMBER)) return false
        return true
    }

    fun checkBonusNumberDuplicate(bonusNumber: Int, winLotto: Lotto): Boolean {
        if (winLotto.checkBonusNumberDuplicate(bonusNumber)) return true
        return false
    }
}