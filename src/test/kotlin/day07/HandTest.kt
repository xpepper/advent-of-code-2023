package day07

import day07.Card.A
import day07.Card.EIGHT
import day07.Card.FIVE
import day07.Card.FOUR
import day07.Card.NINE
import day07.Card.SIX
import day07.Card.T
import day07.Card.THREE
import day07.Card.TWO
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.comparables.shouldBeLessThan
import org.junit.jupiter.api.Test

private val fiveOfAKind = Hand(A, A, A, A, A)
private val fourOfAKind = Hand(A, A, EIGHT, A, A)
private val fullHouse = Hand(TWO, THREE, THREE, THREE, TWO)
private val threeOfAKind = Hand(T, T, T, NINE, EIGHT)
private val twoPairs = Hand(TWO, THREE, FOUR, THREE, TWO)
private val onePair = Hand(A, TWO, THREE, A, FOUR)
private val highCard = Hand(TWO, THREE, FOUR, FIVE, SIX)

class HandTest {
    @Test
    fun `Five of a kind`() {
        fiveOfAKind shouldBeGreaterThan fourOfAKind
        fiveOfAKind shouldBeGreaterThan fullHouse
        fiveOfAKind shouldBeGreaterThan threeOfAKind
        fiveOfAKind shouldBeGreaterThan twoPairs
        fiveOfAKind shouldBeGreaterThan onePair
        fiveOfAKind shouldBeGreaterThan highCard
    }

    @Test
    fun `Four of a kind`() {
        fourOfAKind shouldBeLessThan fiveOfAKind

        fourOfAKind shouldBeGreaterThan fullHouse
        fourOfAKind shouldBeGreaterThan threeOfAKind
        fourOfAKind shouldBeGreaterThan twoPairs
        fourOfAKind shouldBeGreaterThan onePair
        fourOfAKind shouldBeGreaterThan highCard
    }

    @Test
    fun `Full house`() {
        fullHouse shouldBeLessThan fiveOfAKind
        fullHouse shouldBeLessThan fourOfAKind

        fullHouse shouldBeGreaterThan threeOfAKind
        fullHouse shouldBeGreaterThan twoPairs
        fullHouse shouldBeGreaterThan onePair
        fullHouse shouldBeGreaterThan highCard
    }
}
