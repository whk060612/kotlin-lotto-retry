package lotto.domain

import lotto.utils.*

enum class Rank(val prize: Int) {
    FIRST(FIRST_RANK_PRIZE),
    SECOND(SECOND_RANK_PRIZE),
    THIRD(THIRD_RANK_PRIZE),
    FOURTH(FOURTH_RANK_PRIZE),
    FIFTH(FIFTH_RANK_PRIZE),
    NOTHING(NOTHING_RANK_PRIZE)
}