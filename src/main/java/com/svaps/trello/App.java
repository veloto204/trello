package com.svaps.trello;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final Logger logger = LogManager.getLogger();

    /**
     * Moves card identified by <code>cardId</code> from source column to target column into a given position
     *
     * @param board
     * @param cardId
     * @param sourceColumnId
     * @param targetColumnId
     * @param position       zero-based card position. If <code>-1</code> is passed then card is inserted at the beginning.
     *                       If value is equal or greater than number of cards in the column - the card is appended to the end of list
     */
    public static void moveCard(Board board, int cardId, int sourceColumnId, int targetColumnId, int position) {
        List<Card> cards = new ArrayList<Card>();
        cards = App.getColumnCards(board, targetColumnId);
        Card card = board.getColumnById(sourceColumnId).getCardById(cardId);
        try {
            if (cards.size() - 1 >= position) {
                for (Card card1 : cards) {
                    board.getColumnById(targetColumnId).deleteCardById(card1.getId()); //cleaning of all the cards
                }
                cards.add(Math.max(position, 0), card);
                for (Card card1 : cards) {
                    board.getColumnById(targetColumnId).addCard(card1); //add an element according to the given position
                }
            } else {
                board.getColumnById(targetColumnId).addCard(card); //adding a map to the end
            }
        } catch (Exception e) {
            logger.error(e);
        }
        board.getColumnById(sourceColumnId).deleteCardById(cardId);
    }

    /**
     * Returns a list of cards of the column identified by <code>columnId</code>
     *
     * @param board
     * @param columnId
     */
    public static List<Card> getColumnCards(Board board, int columnId) {
        int max = 0;
        int position = 0;
        List<Card> cards = new ArrayList<Card>();
        Column column = board.getColumnById(columnId);
        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (column.getCardById(i) != null) {
                    max++; //search number of cards
                }
            }
            while (position <= max - 1) { //adding all items in order
                cards.add(board.getColumnById(columnId).getCardByPosition(position++));
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return cards;
    }

    /**
     * Does nothing
     *
     * @param args
     */
    public static void main(String[] args) {
    }

}
