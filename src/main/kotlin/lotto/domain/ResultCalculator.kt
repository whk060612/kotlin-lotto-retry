package lotto.domain

import lotto.data.*
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
        if (correctCount == Rank.FIRST.correctCount) return Rank.FIRST
        if (correctCount == Rank.SECOND.correctCount) {
            if (bonusNumberCorrect) return Rank.SECOND
            return Rank.THIRD
        }
        if (correctCount == Rank.FOURTH.correctCount) return Rank.FOURTH
        if (correctCount == Rank.FIFTH.correctCount) return Rank.FIFTH
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