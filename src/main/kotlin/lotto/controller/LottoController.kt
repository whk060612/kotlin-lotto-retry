package lotto.controller

import lotto.data.ErrorMessage
import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoMoney
import lotto.exception.InputValidator
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

    fun readWinLotto(): Lotto {
        val winNumbers = inputView.readWinNumbers()
        return Lotto(winNumbers)
    }

    fun readBonusNumber(winLotto: Lotto): Int {
        val bonusNumber = inputView.readBonusNumber()
        val inputValidator = InputValidator()
        if (!inputValidator.checkNumberRange(bonusNumber)) throw IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ILLEGAL.message)
        if (inputValidator.checkBonusNumberDuplicate(
                bonusNumber,
                winLotto
            )
        ) throw IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.message)
        return bonusNumber
    }

}