package com.codecool.playingcards.service;

import com.codecool.playingcards.model.DeckDescriptor;
import com.codecool.playingcards.model.Card;

import java.util.Collection;

public interface CardGenerator {
    Collection<Card> generate(DeckDescriptor deckDescriptor);
}