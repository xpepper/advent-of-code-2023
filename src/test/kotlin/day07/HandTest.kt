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

class HandTest {
    @Test
    fun `Five of a kind is the strongest type of hand`() {
        Hand(A, A, A, A, A) shouldBeGreaterThan Hand(A, A, EIGHT, A, A) // Four of a kind
        Hand(A, A, A, A, A) shouldBeGreaterThan Hand(TWO, THREE, THREE, THREE, TWO) // Full house
        Hand(A, A, A, A, A) shouldBeGreaterThan Hand(T, T, T, NINE, EIGHT) // Three of a kind
        Hand(A, A, A, A, A) shouldBeGreaterThan Hand(TWO, THREE, FOUR, THREE, TWO) // Two pair
        Hand(A, A, A, A, A) shouldBeGreaterThan Hand(A, TWO, THREE, A, FOUR) // One pair
        Hand(A, A, A, A, A) shouldBeGreaterThan Hand(A, TWO, THREE, A, FOUR) // One pair
        Hand(A, A, A, A, A) shouldBeGreaterThan Hand(TWO, THREE, FOUR, FIVE, SIX) // High card
    }

    @Test
    fun `Full house is weaker than Five of a kind and stronger of all the other types of hand`() {
        Hand(TWO, THREE, THREE, THREE, TWO) shouldBeLessThan Hand(A, A, A, A, A) // Five of a kind
        Hand(TWO, THREE, THREE, THREE, TWO) shouldBeGreaterThan Hand(T, T, T, NINE, EIGHT) // Three of a kind
        Hand(TWO, THREE, THREE, THREE, TWO) shouldBeGreaterThan Hand(TWO, THREE, FOUR, THREE, TWO) // Two pair
        Hand(TWO, THREE, THREE, THREE, TWO) shouldBeGreaterThan Hand(A, TWO, THREE, A, FOUR) // One pair
        Hand(TWO, THREE, THREE, THREE, TWO) shouldBeGreaterThan Hand(A, TWO, THREE, A, FOUR) // One pair
        Hand(TWO, THREE, THREE, THREE, TWO) shouldBeGreaterThan Hand(TWO, THREE, FOUR, FIVE, SIX) // High card
    }
}
