package lotto.data

enum class ErrorMessage(val message: String) {
    ERROR_MESSAGE("[ERROR]"),
    LOTTO_NUMBER_COUNT_ILLEGAL("${ERROR_MESSAGE} 로또 번호는 6개의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ILLEGAL("${ERROR_MESSAGE} 로또 번호는 중복되면 안됩니다."),
    NOT_NUMBER("${ERROR_MESSAGE} 숫자를 입력해주세요."),
    MONEY_NOT_1000("${ERROR_MESSAGE} 1,000원 단위로 입력해주세요.")
}