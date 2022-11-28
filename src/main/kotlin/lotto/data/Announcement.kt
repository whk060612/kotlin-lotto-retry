package lotto.data

enum class Announcement(val message: String) {
    INPUT_MONEY_MENT("구입금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBER_MENT("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MENT("보너스 번호를 입력해 주세요."),
    OUTPUT_RESULT_MENT(
        "당첨 통계\n---"
    )

}