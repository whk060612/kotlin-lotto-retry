package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.view.AnnouncementOutputView
import lotto.view.InputView
import lotto.view.ResultOutputView

class LottoController {

    private val announcementOutputView = AnnouncementOutputView()
    private val inputView = InputView()

    fun readBuyMoney(): Int {
        announcementOutputView.printInputMoneyMent()
        return inputView.readBuyMoney()
    }

    fun generateLotto(money: Int): List<Lotto> {
        val lottoGenerator = LottoGenerator(money / 1000)
        return lottoGenerator.generate()
    }

    fun printLotto(lottos:List<Lotto>){
        val resultOutputView = ResultOutputView()
        resultOutputView.printLottoCount(lottos.size)
        resultOutputView.printLottos(lottos)
    }

}