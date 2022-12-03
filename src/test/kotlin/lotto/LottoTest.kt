package lotto

import lotto.domain.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse


class LottoTest {
    val winNumber = Lotto(listOf(1, 2, 3, 4, 5, 6))

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `로또 번호와 당첨 번호를 비교하여 숫자 1개가 맞음`() {
        val lotto = Lotto(listOf(6, 7, 8, 9, 10, 11))
        val result = lotto.countCorrectNumber(winNumber)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `로또 번호와 당첨 번호를 비교하여 숫자 3개가 맞음`() {
        val lotto = Lotto(listOf(1, 2, 3, 9, 10, 11))
        val result = lotto.countCorrectNumber(winNumber)
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `보너스 번호에 당첨됨`(){
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val result = lotto.checkBonusNumberCorrect(6)
        assertTrue(result)
    }

    @Test
    fun `보너스 번호에 당첨되지 않음`(){
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val result = lotto.checkBonusNumberCorrect(7)
        assertFalse(result)
    }

}
