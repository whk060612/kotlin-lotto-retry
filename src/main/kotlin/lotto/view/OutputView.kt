package lotto.view

import lotto.data.InputMent
import lotto.data.ResultMent
import lotto.domain.Lotto

class OutputView {
    fun printInputMoneyMent() {
        println(InputMent.INPUT_MONEY_MENT.message)
    }

    fun printLottoCount(count: Int) {
        println(ResultMent.LOTTO_COUNT_MENT.getLottoCountMent(count))
    }

    fun printLottos(lottos: List<Lotto>) {
        for (lotto in lottos) {
            println(lotto.getNumbers())
        }
    }

    fun printInputWinNumbersMent() {
        println(InputMent.INPUT_LOTTO_NUMBER_MENT.message)
    }

    fun printInputBonusNumberMent() {
        println(InputMent.INPUT_BONUS_NUMBER_MENT.message)
    }

    fun printResultMent() {
        println(ResultMent.RESULT_MENT.message)
    }

    fun printRankResult(rankCounts: List<Int>) {
        val ments = listOf(
            ResultMent.FIRST_RESULT_MENT,
            ResultMent.SECOND_RESULT_MENT,
            ResultMent.THIRD_RESULT_MENT,
            ResultMent.FOURTH_RESULT_MENT,
            ResultMent.FIFTH_RESULT_MENT
        )
        for (index in rankCounts.size - 1 downTo 0) {
            println(ments[index].getResultMent(rankCounts[index]))
        }
    }

    fun printYieldResult(yieldValue: Double) {
        println(ResultMent.YIELD_MENT.getYieldMent(yieldValue))
    }
}