package lotto

import lotto.controller.LottoController

fun main() {
    val lottoController = LottoController()
    val lottoMoney = lottoController.readLottoMoney()
    val lottos = lottoController.generateLotto(lottoMoney.getLottoCount())
    lottoController.printLotto(lottos)
    val winLotto = lottoController.readWinLotto()
    val bonusNumber = lottoController.readBonusNumber(winLotto)
    val rankResult = lottoController.calculateRankResult(lottos, Pair(winLotto, bonusNumber))
    val rankCounts = lottoController.calculateRankCounts(rankResult)
    val yieldValue = lottoController.calculateYield(rankResult, lottoMoney.getLottoCount())
    lottoController.printResult(rankCounts, yieldValue)
}