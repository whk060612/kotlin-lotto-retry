package lotto.exception

import lotto.data.ErrorMessage

class BuyMoneyValidator {

    fun checkBuyMoney(input: String): Int {
        val money = checkBuyMoneyIsInteger(input)
        return checkBuyMoneyIs1000(money)
    }

    private fun checkBuyMoneyIsInteger(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.NOT_NUMBER.message)
    }

    private fun checkBuyMoneyIs1000(money: Int): Int {
        if (money % 1000 == 0) return money
        throw IllegalArgumentException(ErrorMessage.MONEY_NOT_1000.message)
    }

}