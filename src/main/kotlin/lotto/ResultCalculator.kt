package lotto

import lotto.data.*

class ResultCalculator {

    fun calculateRank(correctCount: Int, bonusNumberCorrect: Boolean): Rank = when (correctCount) {
        FIRST_CORRECT_COUNT -> Rank.FIRST
        SECOND_AND_THIRD_CORRECT_COUNT -> if (bonusNumberCorrect) Rank.SECOND else Rank.THIRD
        FOURTH_CORRECT_COUNT -> Rank.FOURTH
        else -> Rank.FIFTH
    }

}