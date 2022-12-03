package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.LOTTO_NUMBER_COUNT
import lotto.utils.MAXIMUM_LOTTO_NUMBER
import lotto.utils.MINIMUM_LOTTO_NUMBER

class LottoGenerator(private val count: Int) {
    fun generate(): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        for (index in 0 until count) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT
            )
            lottos.add(Lotto(numbers))
        }
        return lottos
    }
}