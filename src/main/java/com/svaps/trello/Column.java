package com.svaps.trello;

import java.util.ArrayList;
import java.util.List;

/**
 * Column
 */
class Column {

    private int id;
    private List<Card> cards = new ArrayList<Card>();

    public Column(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Card getCardByPosition(int position) {
        return cards.get(position);
    }

    public Card getCardById(int id) {
        for (Card card : cards) {
            if (card.getId() == id) {
                return card;
            }
        }
        return null;
    }

    public void deleteCardById(int id) {
        cards.remove(getCardById(id));
    }

    public void addCard(Card card) {
        cards.add(card);
    }

}
