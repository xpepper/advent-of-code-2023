package day07.partone

import day07.PartOne.Card.A
import day07.PartOne.Card.EIGHT
import day07.PartOne.Card.FIVE
import day07.PartOne.Card.FOUR
import day07.PartOne.Card.J
import day07.PartOne.Card.NINE
import day07.PartOne.Card.SEVEN
import day07.PartOne.Card.SIX
import day07.PartOne.Card.T
import day07.PartOne.Card.THREE
import day07.PartOne.Card.TWO
import day07.PartOne.Hand
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

    @Test
    fun `Three of a kind`() {
        threeOfAKind shouldBeLessThan fiveOfAKind
        threeOfAKind shouldBeLessThan fourOfAKind
        threeOfAKind shouldBeLessThan fullHouse

        threeOfAKind shouldBeGreaterThan twoPairs
        threeOfAKind shouldBeGreaterThan onePair
        threeOfAKind shouldBeGreaterThan highCard
    }

    @Test
    fun `Two pairs`() {
        twoPairs shouldBeLessThan fiveOfAKind
        twoPairs shouldBeLessThan fourOfAKind
        twoPairs shouldBeLessThan fullHouse
        twoPairs shouldBeLessThan threeOfAKind

        twoPairs shouldBeGreaterThan onePair
        twoPairs shouldBeGreaterThan highCard
    }

    @Test
    fun `One pair`() {
        onePair shouldBeLessThan fiveOfAKind
        onePair shouldBeLessThan fourOfAKind
        onePair shouldBeLessThan fullHouse
        onePair shouldBeLessThan threeOfAKind
        onePair shouldBeLessThan twoPairs

        onePair shouldBeGreaterThan highCard
    }

    @Test
    fun `High card`() {
        highCard shouldBeLessThan fiveOfAKind
        highCard shouldBeLessThan fourOfAKind
        highCard shouldBeLessThan fullHouse
        highCard shouldBeLessThan threeOfAKind
        highCard shouldBeLessThan twoPairs
        highCard shouldBeLessThan onePair
    }

    @Test
    fun `highest card win when comparing two hands of the same type`() {
        Hand(J, J, J, J, J) shouldBeGreaterThan Hand(NINE, NINE, NINE, NINE, NINE)
        Hand(J, J, J, J, J) shouldBeLessThan Hand(A, A, A, A, A)

        Hand(NINE, NINE, EIGHT, NINE, NINE) shouldBeGreaterThan Hand(TWO, TWO, EIGHT, TWO, TWO)
        Hand(NINE, NINE, EIGHT, NINE, NINE) shouldBeLessThan Hand(A, A, EIGHT, A, A)

        Hand(TWO, J, J, J, TWO) shouldBeGreaterThan Hand(TWO, THREE, THREE, THREE, TWO)
        Hand(TWO, J, J, J, TWO) shouldBeLessThan Hand(TWO, A, A, A, TWO)

        Hand(T, T, T, NINE, EIGHT) shouldBeGreaterThan Hand(T, T, T, FOUR, EIGHT)
        Hand(T, T, T, NINE, EIGHT) shouldBeLessThan Hand(A, A, A, NINE, EIGHT)

        Hand(NINE, THREE, FOUR, THREE, NINE) shouldBeGreaterThan Hand(TWO, THREE, FOUR, THREE, TWO)
        Hand(TWO, J, FOUR, J, TWO) shouldBeLessThan Hand(T, THREE, FOUR, THREE, T)

        Hand(A, TWO, THREE, A, FOUR) shouldBeGreaterThan Hand(T, TWO, THREE, T, FOUR)
        Hand(A, TWO, THREE, A, FOUR) shouldBeLessThan Hand(A, TWO, THREE, A, FIVE)

        Hand(THREE, FOUR, FIVE, SIX, SEVEN) shouldBeGreaterThan Hand(TWO, THREE, FOUR, FIVE, SIX)
        Hand(THREE, FOUR, FIVE, SIX, SEVEN) shouldBeLessThan Hand(FOUR, FIVE, SIX, SEVEN, EIGHT)
    }
}
