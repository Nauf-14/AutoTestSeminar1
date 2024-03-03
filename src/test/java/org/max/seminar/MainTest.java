package org.max.seminar;

import org.junit.jupiter.api.*;
import org.max.seminar.exception.DeckEmptyException;
import org.max.seminar.type.Ranks;
import org.max.seminar.type.Suits;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    static List<Card> cards;
    Deck deck ;

    @BeforeAll
    static void beforeAll() {
        cards = new ArrayList<>();
    }

    @BeforeEach
    void Unit() {
        deck = new Deck(cards);

    }

    @AfterEach
    void afterEach(){
        cards.clear();
    }

    @Test
    @Disabled
    void getEmptyDeck() throws DeckEmptyException {
        Assertions.assertThrows(DeckEmptyException.class,()->deck.getCard());
    }

    @Test
    void getOneCard() throws DeckEmptyException {
        Card card = new Card(Ranks.ACE, Suits.DIAMONDS);
        cards.add(card);
        Card newCard = deck.getCard();
        Assertions.assertAll(
                ()-> Assertions.assertEquals(card, newCard),
                ()-> Assertions.assertThrows(DeckEmptyException.class,()->deck.getCard()),
                ()-> Assertions.assertEquals(0, deck.getCards().size())
        );
    }
}
