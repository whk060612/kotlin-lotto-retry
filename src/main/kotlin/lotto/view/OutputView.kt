package lotto.view

import lotto.data.Announcement
import lotto.data.ResultMent
import lotto.domain.Lotto

class OutputView {
    fun printInputMoneyMent(){
        println(Announcement.INPUT_MONEY_MENT.message)
    }

    fun printLottoCount(count: Int) {
        println(ResultMent.LOTTO_COUNT_MENT.getLottoCountMent(count))
    }

    fun printLottos(lottos: List<Lotto>) {
        for (lotto in lottos) {
            println(lotto.getNumbers())
        }
    }

    fun printInputWinNumbersMent(){
        println(Announcement.INPUT_LOTTO_NUMBER_MENT.message)
    }

    fun printInputBonusNumberMent(){
        println(Announcement.INPUT_BONUS_NUMBER_MENT.message)
    }
}