package com.svaps.trello;


import java.util.ArrayList;
import java.util.List;

public class App {

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
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (column.getCardById(i) != null) {
                max++;
            }
        }
        while (position <= max-1) {
            cards.add(board.getColumnById(columnId).getCardByPosition(position++));
        }
        return cards;
    }





       /* while (position <= max - 1) {
            cards.add(board.getColumnById(columnId).getCardByPosition(position++));
        }
        return cards;*/


    /**
     * Does nothing
     *
     * @param args
     */
    public static void main(String[] args) {
    }

}