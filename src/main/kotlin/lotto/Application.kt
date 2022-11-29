package lotto

import lotto.controller.LottoController

fun main() {
    val lottoController = LottoController()
    val lottoMoney = lottoController.readLottoMoney()
    val lottos = lottoController.generateLotto(lottoMoney.getLottoCount())
    lottoController.printLotto(lottos)
    val winLotto = lottoController.readWinLotto()
    val bonusNumber = lottoController.readBonusNumber(winLotto)
}