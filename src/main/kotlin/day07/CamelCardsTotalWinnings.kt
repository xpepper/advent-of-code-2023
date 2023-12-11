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

    private fun type(): Int {
        return when {
            isFiveOfAKind() -> 7
            isFourOfAKind() -> 6
            isFullHouse() -> 5
            else -> 1
        }
    }

    private fun isFiveOfAKind(): Boolean = cards.groupBy { it.label }.count { (_, group) -> group.size == 5 } == 1
    private fun isFourOfAKind(): Boolean = cards.groupBy { it.label }.count { (_, group) -> group.size == 4 } == 1
    private fun isFullHouse(): Boolean {
        val groups = cards.groupBy { it.label }
        return (groups.count { (_, group) -> group.size == 3 } == 1) && groups.size == 2
    }

    private fun compareByStrongest(hand: Hand, other: Hand): Int {
        TODO()
        return Random(System.currentTimeMillis()).nextInt()
    }
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
        fun from(label: String): Card {
            return entries.find { it.label == label } ?: throw InvalidCard(label)
        }
    }

    data class InvalidCard(val label: String) : RuntimeException("Invalid card with label $label")
}

