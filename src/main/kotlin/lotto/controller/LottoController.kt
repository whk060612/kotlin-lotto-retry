package lotto.controller

import lotto.domain.*
import lotto.utils.LOTTO_MONEY_UNIT
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    private val outputView = OutputView()
    private val inputView = InputView()

    private val resultCalculator = ResultCalculator()

    fun start() {
        val lottoMoney = readLottoMoney()
        val lottos = generateLotto(lottoMoney.getLottoCount())
        printLotto(lottos)
        val winLotto = readWinLotto()
        val rankResult = calculateRankResult(lottos, Pair(winLotto, readBonusNumber(winLotto)))
        printResult(calculateRankCounts(rankResult), calculateYield(rankResult, lottoMoney.getLottoCount()))
    }

    private fun readLottoMoney(): LottoMoney {
        outputView.printInputMoneyMent()
        val lottoMoney = repeatInputProcess { inputView.readLottoMoney() }
        return lottoMoney as LottoMoney
    }

    private fun generateLotto(lottoCount: Int): List<Lotto> {
        val lottoGenerator = LottoGenerator(lottoCount)
        return lottoGenerator.generate()
    }

    private fun printLotto(lottos: List<Lotto>) {
        outputView.printLottoCount(lottos.size)
        outputView.printLottos(lottos)
    }

    private fun readWinLotto(): Lotto {
        outputView.printInputWinNumbersMent()
        val winNumbers = repeatInputProcess { inputView.readWinNumbers() }
        return winNumbers as Lotto
    }

    private fun readBonusNumber(winLotto: Lotto): Int {
        outputView.printInputBonusNumberMent()
        val bonusNumber = repeatInputProcess { inputView.readBonusNumber(winLotto) }
        return bonusNumber as Int
    }

    private fun printResult(rankCounts: List<Int>, yieldValue: Double) {
        outputView.printResultMent()
        outputView.printRankResult(rankCounts)
        outputView.printYieldResult(yieldValue)
    }

    private fun calculateRankResult(lottos: List<Lotto>, winNumbers: Pair<Lotto, Int>): List<Rank> {
        return resultCalculator.calculateRankResult(lottos, winNumbers)
    }

    private fun calculateRankCounts(rankResult: List<Rank>): List<Int> {
        val rankCounts = mutableListOf(0, 0, 0, 0, 0)
        for (rank in rankResult) {
            when (rank) {
                Rank.FIRST -> rankCounts[0] += 1
                Rank.SECOND -> rankCounts[1] += 1
                Rank.THIRD -> rankCounts[2] += 1
                Rank.FOURTH -> rankCounts[3] += 1
                else -> rankCounts[4] += 1
            }
        }
        return rankCounts
    }

    private fun calculateYield(ranks: List<Rank>, lottoCount: Int): Double {
        return resultCalculator.calculateYieldRate(ranks, lottoCount * LOTTO_MONEY_UNIT)
    }

    private fun repeatInputProcess(inputProcess: () -> Any): Any {
        while (true) {
            try {
                return inputProcess()
            } catch (exception: IllegalArgumentException) {
                outputView.printErrorMessage(exception.message.toString())
            }
        }
    }
}