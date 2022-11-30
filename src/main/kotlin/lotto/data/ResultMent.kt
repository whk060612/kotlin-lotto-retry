package lotto.data

enum class ResultMent(val message: String) {
    LOTTO_COUNT_MENT("개를 구매했습니다."),
    RESULT_MENT(
        "당첨 통계\n---"
    ),
    FIRST_RESULT_MENT("6개 일치 (2,000,000,000원)"),
    SECOND_RESULT_MENT("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_RESULT_MENT("5개 일치 (1,500,000원)"),
    FOURTH_RESULT_MENT("4개 일치 (50,000원)"),
    FIFTH_RESULT_MENT("3개 일치 (5,000원)"),
    YIELD_MENT("총 수익률은");

    fun getResultMent(count: Int): String {
        return "${this.message} - ${count}개"
    }

    fun getYieldMent(yieldValue: Double): String {
        return "${this.message} ${yieldValue}%입니다."
    }

    fun getLottoCountMent(count: Int): String {
        return "$count${this.message}"
    }
}