
class Yatzy(die1: Int, die2: Int, die3: Int, die4: Int, die5: Int) {

    private val dice = listOf(die1, die2, die3, die4, die5)

    private fun buildSerie(number: Int) = dice.filter { it == number }.sum()

    fun ones(): Int = buildSerie(1)

    fun twos(): Int = buildSerie(2)

    fun threes(): Int = buildSerie(3)

    fun fours(): Int = buildSerie(4)

    fun fives(): Int = buildSerie(5)

    fun sixes(): Int = buildSerie(6)

    fun chance(): Int = dice.sum()

    fun yatzy(): Int {
        return if (dice.distinct().size > 1)
            0
        else
            50
    }

    fun onePair(): Int {
        val pairs = dice.groupingBy { it }.eachCount().filter { it.value > 1 }
        return pairs.keys.map { it * 2 }.max()!!
    }

    companion object {

        fun twoPair(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
            val counts = IntArray(6)
            counts[d1 - 1]++
            counts[d2 - 1]++
            counts[d3 - 1]++
            counts[d4 - 1]++
            counts[d5 - 1]++
            var n = 0
            var score = 0
            var i = 0
            while (i < 6) {
                if (counts[6 - i - 1] >= 2) {
                    n++
                    score += 6 - i
                }
                i += 1
            }
            return if (n == 2)
                score * 2
            else
                0
        }

        fun fourOfAKind(_1: Int, _2: Int, d3: Int, d4: Int, d5: Int): Int {
            val tallies: IntArray = IntArray(6)
            tallies[_1 - 1]++
            tallies[_2 - 1]++
            tallies[d3 - 1]++
            tallies[d4 - 1]++
            tallies[d5 - 1]++
            for (i in 0..5)
                if (tallies[i] >= 4)
                    return (i + 1) * 4
            return 0
        }

        fun threeOfAKind(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
            val t: IntArray = IntArray(6)
            t[d1 - 1]++
            t[d2 - 1]++
            t[d3 - 1]++
            t[d4 - 1]++
            t[d5 - 1]++
            for (i in 0..5)
                if (t[i] >= 3)
                    return (i + 1) * 3
            return 0
        }

        fun smallStraight(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
            val tallies: IntArray = IntArray(6)
            tallies[d1 - 1] += 1
            tallies[d2 - 1] += 1
            tallies[d3 - 1] += 1
            tallies[d4 - 1] += 1
            tallies[d5 - 1] += 1
            return if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
            ) 15 else 0
        }

        fun largeStraight(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
            val tallies: IntArray = IntArray(6)
            tallies[d1 - 1] += 1
            tallies[d2 - 1] += 1
            tallies[d3 - 1] += 1
            tallies[d4 - 1] += 1
            tallies[d5 - 1] += 1
            return if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1
            ) 20 else 0
        }

        fun fullHouse(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
            val tallies: IntArray
            var _2 = false
            var i: Int
            var _2_at = 0
            var _3 = false
            var _3_at = 0

            tallies = IntArray(6)
            tallies[d1 - 1] += 1
            tallies[d2 - 1] += 1
            tallies[d3 - 1] += 1
            tallies[d4 - 1] += 1
            tallies[d5 - 1] += 1

            i = 0
            while (i != 6) {
                if (tallies[i] == 2) {
                    _2 = true
                    _2_at = i + 1
                }
                i += 1
            }

            i = 0
            while (i != 6) {
                if (tallies[i] == 3) {
                    _3 = true
                    _3_at = i + 1
                }
                i += 1
            }

            return if (_2 && _3)
                _2_at * 2 + _3_at * 3
            else
                0
        }
    }
}


