package lotto

import lotto.data.ErrorMessage.*
import lotto.data.LOTTO_NUMBER_COUNT

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_COUNT_ILLEGAL.message }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_DUPLICATE_ILLEGAL.message }
    }

    // TODO: 추가 기능 구현
}
