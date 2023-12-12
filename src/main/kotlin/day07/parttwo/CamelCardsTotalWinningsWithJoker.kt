package day07.parttwo

import day07.handsAndBids
import day07.parttwo.Card.J

fun main() {
    handsAndBids.split("\n")
        .asSequence()
        .map { it.split(" ") }
        .map { (hand, bid) ->
            HandAndBid(
                Hand(hand.toCharArray().map { Card.from(it.toString()) }),
                bid.toInt()
            )
        }
        .sortedBy { it.hand }
        .mapIndexed { index, handAndBid -> (index + 1) * handAndBid.bid }
        .sum()
        .also(::println)
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
    private fun isFourOfAKind(): Boolean {
        return labelGroups.countWithSize(4) == 1 && labelGroups.size == 2
    }

    private fun cards(): List<Card> = cards.asSequence()
        .filterNot { it == J }
        .groupBy { it.label }
        .map { it.value }
        .maxByOrNull { it.size }
        ?.first()
        ?.let { applyJokerRuleOn(it) } ?: cards

    private fun applyJokerRuleOn(targetCard: Card) = cards.map { card -> if (card == J) targetCard else card }

    private fun isFullHouse() = labelGroups.countWithSize(3) == 1 && labelGroups.size == 2
    private fun isThreeOfAKind() = labelGroups.countWithSize(3) == 1 && labelGroups.size == 3
    private fun isTwoPairs() = labelGroups.countWithSize(2) == 2 && labelGroups.size == 3
    private fun isOnePair() = labelGroups.countWithSize(2) == 1 && labelGroups.size == 4
    private fun isHighCard() = labelGroups.countWithSize(1) == 5

    private val labelGroups by lazy { cards().groupBy { it.label } }

    private fun Map<String, List<Card>>.countWithSize(size: Int) =
        count { (_, group) -> group.size == size }

    private fun compareByStrongest(hand: Hand, otherHand: Hand): Int {
        for (i in 0..<5) {
            if (hand.cards[i].value > otherHand.cards[i].value) return 1
            if (hand.cards[i].value < otherHand.cards[i].value) return -1
        }
        throw HandsAreTie(hand, otherHand)
    }

    data class UnknownType(val hand: Hand) : RuntimeException("Invalid type for hand $hand")
    data class HandsAreTie(val hand: Hand, val otherHand: Hand) : RuntimeException("$hand and $otherHand are tie!")
}

enum class Card(val label: String, val value: Int) {
    A("A", 13),
    K("K", 12),
    Q("Q", 11),
    T("T", 10),
    NINE("9", 9),
    EIGHT("8", 8),
    SEVEN("7", 7),
    SIX("6", 6),
    FIVE("5", 5),
    FOUR("4", 4),
    THREE("3", 3),
    TWO("2", 2),
    J("J", 1);

    companion object {
        fun from(label: String): Card = entries.find { it.label == label } ?: throw InvalidCard(label)
    }

    data class InvalidCard(val label: String) : RuntimeException("Invalid card with label $label")
}

