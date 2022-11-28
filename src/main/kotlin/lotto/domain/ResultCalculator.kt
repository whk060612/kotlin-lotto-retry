package lotto.domain

import lotto.data.*
import kotlin.math.roundToInt

class ResultCalculator {

    fun calculateRank(correctCount: Int, bonusNumberCorrect: Boolean): Rank = when (correctCount) {
        FIRST_CORRECT_COUNT -> Rank.FIRST
        SECOND_AND_THIRD_CORRECT_COUNT -> if (bonusNumberCorrect) Rank.SECOND else Rank.THIRD
        FOURTH_CORRECT_COUNT -> Rank.FOURTH
        else -> Rank.FIFTH
    }

    fun calculateYieldRate(prize: Int, buyMoney: Int):Double {
        val yieldRate = prize.toDouble() / buyMoney.toDouble() * 100.0
        val result = (yieldRate * 10.0).roundToInt() / 10.0
        return result
    }

}