package com.codecool.playingcards.service.impl;

import com.codecool.playingcards.model.DeckDescriptor;
import com.codecool.playingcards.service.CardGenerator;
import com.codecool.playingcards.service.Logger;
import com.codecool.playingcards.model.Card;

import java.util.ArrayList;
import java.util.Collection;

public class CardGeneratorImpl implements CardGenerator {
    private final Logger logger;

    public CardGeneratorImpl(Logger logger) {
        this.logger = logger;
    }

    public Collection<Card> generate(DeckDescriptor deckDescriptor) {
        int[] numbers = deckDescriptor.numbers();
        String[] symbols = deckDescriptor.symbols();
        String[] suits = deckDescriptor.suits();

        return generateCards(numbers, symbols, suits);
    }

    private Collection<Card> generateCards(int[] numbers, String[] symbols, String[] suits) {
        Collection<Card> cards = new ArrayList<>();

        for (String suit : suits) {
            addCards(cards, symbols, suit);
            addCards(cards, numbers, suit);
        }
        return cards;
    }

    private void addCards(Collection<Card> cards, int[] values, String suit) {
        for (int value : values) {
            Card card = new Card(Integer.toString(value), suit);
            logger.logInfo(String.format("Generate card %s", card));
            cards.add(card);
        }
    }

    private void addCards(Collection<Card> cards, String[] values, String suit) {
        for (String value : values) {
            Card card = new Card(value, suit);
            logger.logInfo(String.format("Generate card %s", card));
            cards.add(card);
        }
    }
}
