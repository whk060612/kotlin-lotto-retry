package lotto

import lotto.data.FIFTH_CORRECT_COUNT
import lotto.data.Rank
import lotto.data.SECOND_AND_THIRD_CORRECT_COUNT
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ResultCalculatorTest {

    private lateinit var resultCalculator: ResultCalculator

    @BeforeEach
    fun setUp() {
        resultCalculator = ResultCalculator()
    }

    @ParameterizedTest
    @MethodSource("provideRankTestParameters")
    fun `당첨된 등수를 계산한다`(count: Int, bonusNumberCorrect: Boolean, expected: Rank) {
        val result = resultCalculator.calculateRank(count, bonusNumberCorrect)
        assertThat(result).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun provideRankTestParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(FIFTH_CORRECT_COUNT, false, Rank.FIFTH),
                Arguments.of(SECOND_AND_THIRD_CORRECT_COUNT, true, Rank.SECOND),
                Arguments.of(SECOND_AND_THIRD_CORRECT_COUNT, false, Rank.THIRD)
            )
        }
    }

//    @Test
//    fun `수익률을 계산한다`() {
//
//    }
}