package lotto.view

import lotto.data.*
import lotto.domain.Lotto

class OutputView {
    fun printInputMoneyMent() {
        println(INPUT_MONEY_MENT)
    }

    fun printLottoCount(count: Int) {
        println(LOTTO_COUNT_MENT.format(count))
    }

    fun printLottos(lottos: List<Lotto>) {
        for (lotto in lottos) {
            println(lotto.getNumbers())
        }
    }

    fun printInputWinNumbersMent() {
        println(INPUT_LOTTO_NUMBER_MENT)
    }

    fun printInputBonusNumberMent() {
        println(INPUT_BONUS_NUMBER_MENT)
    }

    fun printResultMent() {
        println(RESULT_MENT)
    }

    fun printRankResult(rankCounts: List<Int>) {
        val ments = listOf(
            FIRST_RANK_RESULT,
            SECOND_RANK_RESULT,
            THIRD_RANK_RESULT,
            FOURTH_RANK_RESULT,
            FIFTH_RANK_RESULT
        )
        for (index in rankCounts.size - 1 downTo 0) {
            println(ments[index].format(rankCounts[index]))
        }
    }

    fun printYieldResult(yieldValue: Double) {
        println(YIELD_MENT.format(yieldValue))
    }
}