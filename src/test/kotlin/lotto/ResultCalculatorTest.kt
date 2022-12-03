package lotto

import lotto.domain.Rank
import lotto.domain.Lotto
import lotto.domain.ResultCalculator
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
    fun `당첨된 등수를 계산한다`(lottos: List<Lotto>, winNumber: Pair<Lotto, Int>, expected: List<Rank>) {
        val result = resultCalculator.calculateRankResult(lottos, winNumber)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("provideYieldRankTestParameters")
    fun `수익률을 계산한다`(ranks: List<Rank>, buyMoney: Int, expected: Double) {
        val result = resultCalculator.calculateYieldRate(ranks, buyMoney)
        assertThat(result).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun provideRankTestParameters(): Stream<Arguments> {
            val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(7, 8, 9, 10, 11, 12)))
            return Stream.of(
                Arguments.of(lottos, Pair(Lotto(listOf(1, 2, 3, 7, 8, 9)), 10), listOf(Rank.FIFTH, Rank.FIFTH)),
                Arguments.of(lottos, Pair(Lotto(listOf(1, 2, 3, 4, 5, 6)), 10), listOf(Rank.FIRST)),
                Arguments.of(lottos, Pair(Lotto(listOf(1, 2, 3, 4, 7, 8)), 10), listOf(Rank.FOURTH))
            )
        }

        @JvmStatic
        fun provideYieldRankTestParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(Rank.FIFTH), 8000, 62.5),
                Arguments.of(listOf(Rank.FOURTH, Rank.FIFTH), 10000, 550.0)
            )
        }
    }

}