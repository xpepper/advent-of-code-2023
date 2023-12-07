package day04

fun main() {
    val scratchcards = rawScratchcards.toScratchcards()
    val count = countCards(scratchcards)

    println(count)
}

private data class Scratchcard(val id: Int, val winningNumbers: List<Int>, val yourNumbers: List<Int>)

private fun List<String>.toScratchcards() = mapIndexed { index, row ->
    val (winningNumbers, myNumbers) = row.split(":")[1].trim().split("|")
        .map { it.split(" ").filterNot(String::isBlank).map(String::toInt) }
    Scratchcard(index + 1, winningNumbers, myNumbers)
}

private fun countCards(scratchcards: List<Scratchcard>): Int {
    val cardCopies = scratchcards.toMutableList()
    var totalCards = scratchcards.size

    var i = 0
    while (i < cardCopies.size) {
        val card = cardCopies[i]
        val matches = card.winningNumbers.intersect(card.yourNumbers).size
        for (j in 1..matches) {
            val nextCard = scratchcards.findNextCardOf(card, nextIndex = j)
            if (nextCard != null) {
                cardCopies.add(nextCard)
                totalCards++
            }
        }
        i++
    }

    return totalCards
}

private fun List<Scratchcard>.findNextCardOf(card: Scratchcard, nextIndex: Int) = find { it.id == card.id + nextIndex }
