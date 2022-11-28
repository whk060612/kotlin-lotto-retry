package lotto

import lotto.domain.LottoGenerator
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoGeneratorTest {

    private var count = 0

    @Test
    fun `받은 금액 만큼 로또를 발행한다`() {
        count = 5
        val lottoGenerator = LottoGenerator(count)
        val result = lottoGenerator.generate()
        assertThat(result.size).isEqualTo(count)
    }
}