package lotto.controller

import lotto.data.*
import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoMoney
import lotto.domain.ResultCalculator
import lotto.exception.InputValidator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    private val outputView = OutputView()
    private val inputView = InputView()

    private val resultCalculator = ResultCalculator()

    fun readLottoMoney(): LottoMoney {
        outputView.printInputMoneyMent()
        val inputMoney = inputView.readLottoMoney()
        return LottoMoney(inputMoney)
    }

    fun generateLotto(lottoCount: Int): List<Lotto> {
        val lottoGenerator = LottoGenerator(lottoCount)
        return lottoGenerator.generate()
    }

    fun printLotto(lottos: List<Lotto>) {
        outputView.printLottoCount(lottos.size)
        outputView.printLottos(lottos)
    }

    fun readWinLotto(): Lotto {
        outputView.printInputWinNumbersMent()
        val winNumbers = inputView.readWinNumbers()
        return Lotto(winNumbers)
    }

    fun readBonusNumber(winLotto: Lotto): Int {
        outputView.printInputBonusNumberMent()
        val bonusNumber = inputView.readBonusNumber()
        val inputValidator = InputValidator()
        if (!inputValidator.checkNumberRange(bonusNumber)) throw IllegalArgumentException(LOTTO_NUMBER_RANGE_ILLEGAL)
        if (inputValidator.checkBonusNumberDuplicate(
                bonusNumber,
                winLotto
            )
        ) throw IllegalArgumentException(BONUS_NUMBER_DUPLICATE)
        return bonusNumber
    }

    fun printResult(rankCounts:List<Int>, yieldValue:Double) {
        outputView.printResultMent()
        outputView.printRankResult(rankCounts)
        outputView.printYieldResult(yieldValue)
    }

    fun calculateRankResult(lottos: List<Lotto>, winNumbers: Pair<Lotto, Int>): List<Rank> {
        return resultCalculator.calculateRankResult(lottos, winNumbers)
    }

    fun calculateRankCounts(rankResult: List<Rank>): List<Int> {
        /*리스트에 당첨된 순위 저장*/
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

    fun calculateYield(ranks: List<Rank>, lottoCount: Int): Double {
        return resultCalculator.calculateYieldRate(ranks, lottoCount * LOTTO_MONEY_UNIT)
    }
}