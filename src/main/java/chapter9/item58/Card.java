package chapter9.item58;

import java.util.*;

public class Card {
    private final Suit suit;
    private final Rank rank;

    enum Suit { CLUB, DIAMOND, HEART, SPADE }
    enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING }

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    Card(Suit suit, Rank rank ) {
        this.suit = suit;
        this.rank = rank;
    }

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        // Luckily, the size of suits is not a multiple of the size of ranks.
        // So we will get a NoSuchElementException soon.
        for (Iterator<Suit> it1 = suits.iterator(); it1.hasNext(); )
            for (Iterator<Rank> it2 = ranks.iterator(); it2.hasNext(); )
                // Iterator it1 unintentionally gets advanced in lockstep
                deck.add(new Card(it1.next(), it2.next()));

        // Prefers for-each loop to traditional for loop
        for (Suit suit : suits)
            for (Rank rank : ranks)
                deck.add(new Card(suit, rank));
    }
}
