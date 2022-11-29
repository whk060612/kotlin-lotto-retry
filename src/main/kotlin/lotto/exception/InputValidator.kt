package lotto.exception

/* 입력에서 생기는 예외 검사 */

class InputValidator {
    fun checkInputInteger(input: String): Boolean {
        input.toIntOrNull() ?: return false
        return true
    }
}