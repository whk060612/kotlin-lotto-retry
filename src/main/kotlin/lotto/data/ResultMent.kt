package lotto.data

enum class ResultMent(val message:String) {
    LOTTO_COUNT_MENT("개를 구매했습니다.");

    fun getLottoCountMent(count:Int):String{
        return "$count${this.message}"
    }
}