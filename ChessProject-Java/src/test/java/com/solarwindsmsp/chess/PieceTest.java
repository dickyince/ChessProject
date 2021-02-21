package com.solarwindsmsp.chess;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PieceTest {

    // Class under test
    private Piece testSubject;

    // Mocks used for test
    private ChessBoard mockChessBoard;

    @Before
    public void setUp() {
        testSubject = new Piece(PieceColor.BLACK);
        mockChessBoard = mock(ChessBoard.class);
    }

    @Test
    public void testAddToBoard_False_When_No_Chessboard_Set() {
        boolean addedToBoard = testSubject.addToBaord();
        assertFalse(addedToBoard);
    }

    @Test
    public void testAddToBoard_False_When_No_X_Coordinate_Set() {
        testSubject.setChessBoard(mockChessBoard);
        boolean addedToBoard = testSubject.addToBaord();
        assertFalse(addedToBoard);
    }

    @Test
    public void testAddToBoard_False_When_No_Y_Coordinate_Set() {
        testSubject.setChessBoard(mockChessBoard);
        testSubject.setXCoordinate(0);
        boolean addedToBoard = testSubject.addToBaord();
        assertFalse(addedToBoard);
    }

    @Test
    public void testAddToBoard_True_When_Space_Empty() {
        when(mockChessBoard.addPiece(testSubject)).thenReturn(true);
        testSubject.setChessBoard(mockChessBoard);
        testSubject.setXCoordinate(0);
        testSubject.setYCoordinate(0);
        boolean addedToBoard = testSubject.addToBoard();
        assertTrue(addedToBoard);
    }

    @Test
    public void testAddToBoard_False_When_Space_Full() {
        when(mockChessBoard.addPiece(testSubject)).thenReturn(false);
        testSubject.setChessBoard(mockChessBoard);
        testSubject.setXCoordinate(0);
        testSubject.setYCoordinate(0);
        boolean addedToBoard = testSubject.addToBoard();
        assertFalse(addedToBoard);
    }
}
