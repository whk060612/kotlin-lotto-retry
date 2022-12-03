package lotto.domain

import lotto.utils.LOTTO_MONEY_UNIT
import lotto.utils.MONEY_NOT_1000

class LottoMoney(private val money: Int) {
    init {
        require(money % LOTTO_MONEY_UNIT == 0) { MONEY_NOT_1000 }
    }

    fun getLottoCount(): Int {
        return money / LOTTO_MONEY_UNIT
    }
}