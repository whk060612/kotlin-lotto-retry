package lotto

import lotto.controller.LottoController

fun main() {
    val lottoController = LottoController()
    val money = lottoController.readBuyMoney()
}