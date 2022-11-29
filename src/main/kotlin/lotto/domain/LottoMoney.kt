package lotto.domain

import lotto.data.ErrorMessage
import lotto.data.LOTTO_MONEY_UNIT

class LottoMoney(private val money: Int) {
    init {
        require(money % LOTTO_MONEY_UNIT == 0) { ErrorMessage.MONEY_NOT_1000.message }
    }

    fun getLottoCount(): Int {
        return money / LOTTO_MONEY_UNIT
    }
}