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
    private Column columnSecond;
    private List<Card> listExpected = new ArrayList<Card>();
    private Card cardOne;
    private Card cardTwo;
    private Card cardThree;


    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        board = new Board();
        columnFirst = new Column(2356);
        columnSecond = new Column(534);
        cardOne = new Card(23453);
        cardTwo = new Card(23467);
        cardThree = new Card(34);
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

    @Test
    public void moveCardTestPositionMinusOne() {
        listExpected.add(cardThree);
        listExpected.add(cardOne);
        listExpected.add(cardTwo);
        board.addColumn(columnFirst);
        board.addColumn(columnSecond);
        columnSecond.addCard(new Card(123));
        columnSecond.addCard(new Card(124));
        columnSecond.addCard(cardThree);
        columnFirst.addCard(cardOne);
        columnFirst.addCard(cardTwo);
        App.moveCard(board, 34, 534, 2356, -1);
        assertEquals(listExpected.get(0), columnFirst.getCardByPosition(0));
    }


    @Test
    public void moveCardTestPositionOne() {
        listExpected.add(cardOne);
        listExpected.add(cardThree);
        listExpected.add(cardTwo);
        board.addColumn(columnFirst);
        board.addColumn(columnSecond);
        columnSecond.addCard(new Card(123));
        columnSecond.addCard(new Card(124));
        columnSecond.addCard(cardThree);
        columnFirst.addCard(cardOne);
        columnFirst.addCard(cardTwo);
        App.moveCard(board, 34, 534, 2356, 1);
        assertEquals(listExpected.get(1), columnFirst.getCardByPosition(1));
    }

    @Test
    public void moveCardTestPositionZero() {
        listExpected.add(cardThree);
        board.addColumn(columnFirst);
        board.addColumn(columnSecond);
        columnSecond.addCard(new Card(123));
        columnSecond.addCard(new Card(124));
        columnSecond.addCard(cardThree);
        columnFirst.addCard(cardOne);
        columnFirst.addCard(cardTwo);
        App.moveCard(board, 34, 534, 2356, 0);
        assertEquals(listExpected.get(0), columnFirst.getCardByPosition(0));
    }

    @Test
    public void moveCardTestPositionGreaterThanNumberOfCards() {
        listExpected.add(cardOne);
        listExpected.add(cardTwo);
        listExpected.add(cardThree);
        board.addColumn(columnFirst);
        board.addColumn(columnSecond);
        columnSecond.addCard(new Card(123));
        columnSecond.addCard(new Card(124));
        columnSecond.addCard(cardThree);
        columnFirst.addCard(cardOne);
        columnFirst.addCard(cardTwo);
        App.moveCard(board, 34, 534, 2356, 23);
        assertEquals(listExpected.get(2), columnFirst.getCardByPosition(2));
    }
}
