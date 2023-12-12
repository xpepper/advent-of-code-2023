package day07

import kotlin.random.Random

val handsAndBids = """
    32T3K 765
    T55J5 684
    KK677 28
    KTJJT 220
    QQQJA 483
""".trimIndent()

fun main() {
    var totalWinnings = 0;
    handsAndBids.split("\n")
        .map { it.split(" ") }
        .map { (hand, bid) ->
            HandAndBid(
                Hand(hand.toCharArray().map { Card.from(it.toString()) }),
                bid.toInt()
            )
        }
        .sortedBy { it.hand }
        .forEachIndexed { index, handAndBid -> totalWinnings += (index + 1) * handAndBid.bid }
        .also { println(totalWinnings) }
}

data class HandAndBid(val hand: Hand, val bid: Int)
data class Hand(val cards: List<Card>) : Comparable<Hand> {
    constructor(vararg cards: Card) : this(cards.asList())

    init {
        assert(cards.size == 5)
    }

    override fun compareTo(other: Hand): Int = when {
        this.type() > other.type() -> 1
        this.type() < other.type() -> -1
        else -> compareByStrongest(this, other)
    }

    private fun type(): Int = when {
        isFiveOfAKind() -> 7
        isFourOfAKind() -> 6
        isFullHouse() -> 5
        isThreeOfAKind() -> 4
        isTwoPairs() -> 3
        isOnePair() -> 2
        isHighCard() -> 1
        else -> throw UnknownType(this)
    }

    private fun isFiveOfAKind() = labelGroups.countWithSize(5) == 1
    private fun isFourOfAKind() = labelGroups.countWithSize(4) == 1  && labelGroups.size == 2
    private fun isFullHouse() = labelGroups.countWithSize(3) == 1 && labelGroups.size == 2
    private fun isThreeOfAKind() = labelGroups.countWithSize(3) == 1 && labelGroups.size == 3
    private fun isTwoPairs() = labelGroups.countWithSize(2) == 2 && labelGroups.size == 3
    private fun isOnePair() = labelGroups.countWithSize(2) == 1 && labelGroups.size == 4
    private fun isHighCard() = labelGroups.countWithSize(1) == 5

    private val labelGroups by lazy { cards.groupBy { it.label } }

    private fun Map<String, List<Card>>.countWithSize(size: Int) =
        count { (_, group) -> group.size == size }

    private fun compareByStrongest(hand: Hand, other: Hand): Int {
        TODO()
        return Random(System.currentTimeMillis()).nextInt()
    }
    data class UnknownType(val hand: Hand) : RuntimeException("Invalid type for hand $hand")

}

enum class Card(val label: String, val value: Int) {
    A("A", 14),
    K("K", 13),
    Q("Q", 12),
    J("J", 11),
    T("T", 10),
    NINE("9", 9),
    EIGHT("8", 8),
    SEVEN("7", 7),
    SIX("6", 6),
    FIVE("5", 5),
    FOUR("4", 4),
    THREE("3", 3),
    TWO("2", 2);

    companion object {
        fun from(label: String): Card = entries.find { it.label == label } ?: throw InvalidCard(label)
    }

    data class InvalidCard(val label: String) : RuntimeException("Invalid card with label $label")
}

