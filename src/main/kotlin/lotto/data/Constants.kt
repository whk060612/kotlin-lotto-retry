package lotto.data

// lotto
const val MINIMUM_LOTTO_NUMBER = 1
const val MAXIMUM_LOTTO_NUMBER = 45
const val LOTTO_NUMBER_COUNT = 6
const val LOTTO_MONEY_UNIT = 1000

// lotto rank
const val FIRST_RANK_CORRECT_COUNT = 6
const val SECOND_THIRD_RANK_CORRECT_COUNT = 5
const val FOURTH_RANK_CORRECT_COUNT = 4
const val FIFTH_RANK_CORRECT_COUNT = 3

const val FIRST_RANK_PRIZE = 2_000_000_000
const val SECOND_RANK_PRIZE = 30_000_000
const val THIRD_RANK_PRIZE = 1_500_000
const val FOURTH_RANK_PRIZE = 50_000
const val FIFTH_RANK_PRIZE = 5_000
const val NOTHING_RANK_PRIZE = 0

// Error Message
private const val ERROR_PREFIX = "[ERROR]"
const val LOTTO_NUMBER_COUNT_ILLEGAL = "${ERROR_PREFIX} 로또 번호는 6개의 숫자여야 합니다."
const val LOTTO_NUMBER_DUPLICATE_ILLEGAL = "${ERROR_PREFIX} 로또 번호는 중복되지 않아야 합니다."
const val NOT_NUMBER = "${ERROR_PREFIX} 숫자를 입력해주세요."
const val MONEY_NOT_1000 = "${ERROR_PREFIX} 1,000원 단위로 입력해주세요."
const val LOTTO_NUMBER_RANGE_ILLEGAL = "${ERROR_PREFIX} 로또 번호는 1부터 45 사이의 숫자여야 합니다."
const val BONUS_NUMBER_DUPLICATE = "${ERROR_PREFIX} 당첨 번호와 중복되면 안됩니다."

// Input Ment
const val INPUT_MONEY_MENT = "구입금액을 입력해 주세요."
const val INPUT_LOTTO_NUMBER_MENT = "당첨 번호를 입력해 주세요."
const val INPUT_BONUS_NUMBER_MENT = "보너스 번호를 입력해 주세요."

// Result Ment
const val LOTTO_COUNT_MENT = "%d개를 구매했습니다."
const val RESULT_MENT = "당첨 통계\n---"
const val COUNT_FORMAT = "%d개"
const val FIRST_RANK_RESULT = "6개 일치 (2,000,000,000원) - $COUNT_FORMAT"
const val SECOND_RANK_RESULT = "5개 일치, 보너스 볼 일치 (30,000,000원) - $COUNT_FORMAT"
const val THIRD_RANK_RESULT = "5개 일치 (1,500,000원) - $COUNT_FORMAT"
const val FOURTH_RANK_RESULT = "4개 일치 (50,000원) - $COUNT_FORMAT"
const val FIFTH_RANK_RESULT = "3개 일치 (5,000원) - $COUNT_FORMAT"
const val YIELD_MENT = "총 수익률은 %.1f%%입니다."

