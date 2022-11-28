package lotto.exception

import lotto.data.ErrorMessage.MONEY_NOT_1000
import lotto.data.ErrorMessage.NOT_NUMBER

class Validator {

    fun checkBuyMoney(input: String): Int {
        val money = checkBuyMoneyIsInteger(input)
        return checkBuyMoneyIs1000(money)
    }

    private fun checkBuyMoneyIsInteger(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException(NOT_NUMBER.message)
    }

    private fun checkBuyMoneyIs1000(money: Int): Int {
        if (money % 1000 == 0) return money
        throw IllegalArgumentException(MONEY_NOT_1000.message)
    }
}