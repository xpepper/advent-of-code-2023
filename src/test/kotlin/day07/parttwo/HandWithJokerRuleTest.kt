package day07.parttwo

import day07.PartTwo.Card.A
import day07.PartTwo.Card.EIGHT
import day07.PartTwo.Card.FIVE
import day07.PartTwo.Card.FOUR
import day07.PartTwo.Card.J
import day07.PartTwo.Card.K
import day07.PartTwo.Card.NINE
import day07.PartTwo.Card.Q
import day07.PartTwo.Card.SEVEN
import day07.PartTwo.Card.SIX
import day07.PartTwo.Card.T
import day07.PartTwo.Card.THREE
import day07.PartTwo.Card.TWO
import day07.PartTwo.Hand
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

class HandWithJokerRuleTest {
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
    fun `joker rule`() {
        Hand(Q, J, J, Q, TWO) shouldBeGreaterThan Hand(T, T, T, NINE, EIGHT)
        Hand(K, T, J, J, T) shouldBeGreaterThan Hand(Q, Q, Q, J, A)
        Hand(K, T, J, J, T) shouldBeGreaterThan Hand(T, FIVE, FIVE, J, FIVE)
        Hand(Q, Q, Q, J, A) shouldBeGreaterThan Hand(T, FIVE, FIVE, J, FIVE)
        Hand(TWO, J, J, J, TWO) shouldBeGreaterThan Hand(TWO, A, A, A, TWO)
    }

    @Test
    fun `highest card win when comparing two hands of the same type`() {
        Hand(Q, J, J, Q, TWO) shouldBeGreaterThan threeOfAKind
        Hand(J, J, J, J, J) shouldBeLessThan Hand(A, A, A, A, A)

        Hand(NINE, NINE, EIGHT, NINE, NINE) shouldBeGreaterThan Hand(TWO, TWO, EIGHT, TWO, TWO)
        Hand(NINE, NINE, EIGHT, NINE, NINE) shouldBeLessThan Hand(A, A, EIGHT, A, A)

        Hand(TWO, J, J, J, TWO) shouldBeGreaterThan Hand(TWO, THREE, THREE, THREE, TWO)
        Hand(TWO, J, J, J, TWO) shouldBeGreaterThan Hand(TWO, A, A, A, TWO)

        Hand(T, T, T, NINE, EIGHT) shouldBeGreaterThan Hand(T, T, T, FOUR, EIGHT)
        Hand(T, T, T, NINE, EIGHT) shouldBeLessThan Hand(A, A, A, NINE, EIGHT)

        Hand(NINE, THREE, FOUR, THREE, NINE) shouldBeGreaterThan Hand(TWO, THREE, FOUR, THREE, TWO)
        Hand(TWO, NINE, FOUR, NINE, TWO) shouldBeLessThan Hand(T, THREE, FOUR, THREE, T)

        Hand(A, TWO, THREE, A, FOUR) shouldBeGreaterThan Hand(T, TWO, THREE, T, FOUR)
        Hand(A, TWO, THREE, A, FOUR) shouldBeLessThan Hand(A, TWO, THREE, A, FIVE)

        Hand(THREE, FOUR, FIVE, SIX, SEVEN) shouldBeGreaterThan Hand(TWO, THREE, FOUR, FIVE, SIX)
        Hand(THREE, FOUR, FIVE, SIX, SEVEN) shouldBeLessThan Hand(FOUR, FIVE, SIX, SEVEN, EIGHT)
    }
}
