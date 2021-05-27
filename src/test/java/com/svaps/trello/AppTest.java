package com.svaps.trello;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.svaps.trello.App.getColumnCards;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AppTest {
    private Board board;
    private Column columnFirst;
    private Column columnSecond;


    @Before
    public void setUp() {
        board = new Board();
        columnFirst = new Column(1000);
        columnSecond = new Column(2000);
        board.addColumn(columnFirst);
        board.addColumn(columnSecond);
        columnFirst.addCard(new Card(100));
        columnFirst.addCard(new Card(101));
        columnFirst.addCard(new Card(102));
        columnSecond.addCard(new Card(200));
        columnSecond.addCard(new Card(201));
        columnSecond.addCard(new Card(202));
    }

    @Test
    public void getColumnCardsTest() {
        List<Card> listExpected = Arrays.asList(new Card(100), new Card(101), new Card(102));
        assertEquals(listExpected, getColumnCards(board, 1000));
    }

    @Test
    public void getColumnCardsSecondColumnTest() {
        List<Card> listExpected = Arrays.asList(new Card(200), new Card(201), new Card(202));
        assertEquals(listExpected, getColumnCards(board, 2000));
    }

    @Test
    public void getColumnMixedTest() {
        columnFirst.addCard(new Card(200));
        columnFirst.addCard(new Card(201));
        columnFirst.addCard(new Card(202));
        List<Card> listExpected = Arrays.asList(new Card(100), new Card(101),
                new Card(102), new Card(200), new Card(201), new Card(202));
        assertEquals(listExpected, getColumnCards(board, 1000));
    }

    @Test
    public void moveCardCheckRemoveTest() {
        App.moveCard(board, 100, 1000, 2000, -1);
        assertNull(columnFirst.getCardById(100));
    }

    @Test
    public void moveCardPositionMinusOneTest() {
        App.moveCard(board, 100, 1000, 2000, -1);
        assertNull(columnFirst.getCardById(100));
        assertEquals(new Card(100), columnSecond.getCardByPosition(0));
    }


    @Test
    public void moveCardPositionOneTest() {
        App.moveCard(board, 100, 1000, 2000, 1);
        assertNull(columnFirst.getCardById(100));
        assertEquals(new Card(100), columnSecond.getCardByPosition(1));
    }

    @Test
    public void moveCardPositionZeroTest() {
        App.moveCard(board, 100, 1000, 2000, 0);
        assertNull(columnFirst.getCardById(100));
        assertEquals(new Card(100), columnSecond.getCardByPosition(0));
    }


    @Test
    public void moveCardPositionGreaterThanNumberOfCardsTest() {
        List<Card> listExpected = Arrays.asList(new Card(200), new Card(201), new Card(202), new Card(100));
        App.moveCard(board, 100, 1000, 2000, 23);
        assertEquals(listExpected, App.getColumnCards(board, 2000));
    }
}
