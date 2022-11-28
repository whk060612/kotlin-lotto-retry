package lotto.controller

import lotto.view.AnnouncementOutputView
import lotto.view.InputView

class LottoController {

    private val announcementOutputView = AnnouncementOutputView()
    private val inputView = InputView()

    fun readBuyMoney():Int{
        announcementOutputView.printInputMoneyMent()
        return inputView.readBuyMoney()
    }
}