package lotto.view

import lotto.data.ResultMent
import lotto.domain.Lotto

class ResultOutputView {

    fun printLottoCount(count: Int) {
        println(ResultMent.LOTTO_COUNT_MENT.getLottoCountMent(count))
    }

    fun printLottos(lottos: List<Lotto>) {
        for (lotto in lottos) {
            println(lotto.getNumbers())
        }
    }
}