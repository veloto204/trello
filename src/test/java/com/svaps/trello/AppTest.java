package com.svaps.trello;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    private Board board;
    private Column columnFirst;
    private List<Card> listExpected = new ArrayList<Card>();
    private Card cardOne;
    private Card cardTwo;


    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        board = new Board();
        columnFirst = new Column(2356);
        cardOne = new Card(23453);
        cardTwo = new Card(23467);
    }

    @Test
    public void getColumnCardsTest() {
        listExpected.add(cardOne);
        listExpected.add(cardTwo);
        board.addColumn(columnFirst);
        columnFirst.addCard(cardOne);
        columnFirst.addCard(cardTwo);
        assertEquals(listExpected, App.getColumnCards(board, 2356));
    }

    @Test
    public void getColumnCardsChangeOrderTest() {
        listExpected.add(cardTwo);
        listExpected.add(cardOne);
        board.addColumn(columnFirst);
        columnFirst.addCard(cardTwo);
        columnFirst.addCard(cardOne);
        assertEquals(listExpected, App.getColumnCards(board, 2356));
    }

    @Test
    public void getColumnCardsWrongIdTest() {
        exceptionRule.expect(NullPointerException.class);
        App.getColumnCards(board, 2351);
    }
}
