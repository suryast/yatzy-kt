
import org.junit.*
import org.junit.Assert.*

class YatzyTest {

    @Test
    fun chance_scores_sum_of_all_dice() {
        val expected = 15
        val actual = Yatzy(2, 3, 4, 5, 1).chance()
        assertEquals(expected, actual)
        assertEquals(16, Yatzy(3, 3, 4, 5, 1).chance())
    }

    @Test
    fun yatzy_scores_50() {
        val expected = 50
        val actual = Yatzy(4, 4, 4, 4, 4).yatzy()
        assertEquals(expected, actual)
        assertEquals(50, Yatzy(6, 6, 6, 6, 6).yatzy())
        assertEquals(0, Yatzy(6, 6, 6, 6, 3).yatzy())
    }

    @Test
    fun onesTest() {
        assertEquals(1, Yatzy(1, 2, 3, 4, 5).ones())
        assertEquals(2, Yatzy(1, 2, 1, 4, 5).ones())
        assertEquals(0, Yatzy(6, 2, 2, 4, 5).ones())
        assertEquals(4, Yatzy(1, 2, 1, 1, 1).ones())
    }

    @Test
    fun twosTest() {
        assertEquals(4, Yatzy(1, 2, 3, 2, 6).twos())
        assertEquals(10, Yatzy(2, 2, 2, 2, 2).twos())
    }

    @Test
    fun threesTest() {
        assertEquals(6, Yatzy(1, 2, 3, 2, 3).threes())
        assertEquals(12, Yatzy(2, 3, 3, 3, 3).threes())
    }

    @Test
    fun foursTest() {
        assertEquals(12, Yatzy(4, 4, 4, 5, 5).fours())
        assertEquals(8, Yatzy(4, 4, 5, 5, 5).fours())
        assertEquals(4, Yatzy(4, 5, 5, 5, 5).fours())
    }

    @Test
    fun fivesTest() {
        assertEquals(10, Yatzy(4, 4, 4, 5, 5).fives())
        assertEquals(15, Yatzy(4, 4, 5, 5, 5).fives())
        assertEquals(20, Yatzy(4, 5, 5, 5, 5).fives())
    }

    @Test
    fun sixesTest() {
        assertEquals(0, Yatzy(4, 4, 4, 5, 5).sixes())
        assertEquals(6, Yatzy(4, 4, 6, 5, 5).sixes())
        assertEquals(18, Yatzy(6, 5, 6, 6, 5).sixes())
    }

    @Test
    fun one_pair() {
        assertEquals(6, Yatzy(3, 4, 3, 5, 6).onePair())
        assertEquals(10, Yatzy(5, 3, 3, 3, 5).onePair())
        assertEquals(12, Yatzy(5, 3, 6, 6, 5).onePair())
    }

    @Test
    fun two_Pair() {
        assertEquals(16, Yatzy.twoPair(3, 3, 5, 4, 5))
        assertEquals(16, Yatzy.twoPair(3, 3, 5, 5, 5))
    }

    @Test
    fun three_of_a_kind() {
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 4, 5))
        assertEquals(15, Yatzy.threeOfAKind(5, 3, 5, 4, 5))
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 5))
    }

    @Test
    fun four_of_a_knd() {
        assertEquals(12, Yatzy.fourOfAKind(3, 3, 3, 3, 5))
        assertEquals(20, Yatzy.fourOfAKind(5, 5, 5, 4, 5))
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 3))
    }

    @Test
    fun smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5))
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1))
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5))
    }

    @Test
    fun largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5))
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6))
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5))
    }

    @Test
    fun fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6))
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6))
    }
}