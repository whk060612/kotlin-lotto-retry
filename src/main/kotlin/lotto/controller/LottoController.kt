package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoMoney
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    private val outputView = OutputView()
    private val inputView = InputView()

    fun readLottoMoney(): LottoMoney {
        outputView.printInputMoneyMent()
        val inputMoney = inputView.readLottoMoney()
        return LottoMoney(inputMoney)
    }

    fun generateLotto(money: Int): List<Lotto> {
        val lottoGenerator = LottoGenerator(money / 1000)
        return lottoGenerator.generate()
    }

    fun printLotto(lottos: List<Lotto>) {
        outputView.printLottoCount(lottos.size)
        outputView.printLottos(lottos)
    }

}