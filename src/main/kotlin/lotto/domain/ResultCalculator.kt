package lotto.domain

import lotto.utils.FIFTH_RANK_CORRECT_COUNT
import lotto.utils.FIRST_RANK_CORRECT_COUNT
import lotto.utils.FOURTH_RANK_CORRECT_COUNT
import lotto.utils.SECOND_THIRD_RANK_CORRECT_COUNT
import kotlin.math.roundToInt

class ResultCalculator {

    fun calculateRankResult(lottos: List<Lotto>, winNumber: Pair<Lotto, Int>): List<Rank> {
        val rankResult = mutableListOf<Rank>()
        for (lotto in lottos) {
            val correctCount = lotto.countCorrectNumber(winNumber.first)
            val isBonusNumberCorrect = lotto.checkBonusNumberCorrect(winNumber.second)
            val result = calculateRank(correctCount, isBonusNumberCorrect)
            if (result != Rank.NOTHING) rankResult.add(result)
        }
        return rankResult
    }

    private fun calculateRank(correctCount: Int, bonusNumberCorrect: Boolean): Rank {
        if (correctCount == FIRST_RANK_CORRECT_COUNT) return Rank.FIRST
        if (correctCount == SECOND_THIRD_RANK_CORRECT_COUNT) {
            if (bonusNumberCorrect) return Rank.SECOND
            return Rank.THIRD
        }
        if (correctCount == FOURTH_RANK_CORRECT_COUNT) return Rank.FOURTH
        if (correctCount == FIFTH_RANK_CORRECT_COUNT) return Rank.FIFTH
        return Rank.NOTHING
    }

    fun calculateYieldRate(ranks: List<Rank>, buyMoney: Int): Double {
        var prize = 0
        for (rank in ranks) {
            prize += rank.prize
        }
        val yieldRate = prize.toDouble() / buyMoney.toDouble() * 100.0
        return (yieldRate * 10.0).roundToInt() / 10.0
    }

}