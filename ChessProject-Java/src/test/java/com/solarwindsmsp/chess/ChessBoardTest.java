package com.solarwindsmsp.chess;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChessBoardTest {

    // Class under test
    private ChessBoard testSubject;

    // Mocks used for test
    private Piece testPawn;

    @Before
    public void setUp() {
        testSubject = new ChessBoard();
        testPawn = mock(Pawn.class);
    }

    @Test
    public void testHas_MaxBoardWidth_of_8() {
        assertEquals(8, ChessBoard.MAX_BOARD_HEIGHT);
    }

    @Test
    public void testHas_MaxBoardHeight_of_8() {
        assertEquals(8, ChessBoard.MAX_BOARD_HEIGHT);
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_0_Y_equals_0() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(0, 0);
        assertTrue(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_5_Y_equals_5() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(5, 5);
        assertTrue(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_5() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(11, 5);
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_0_Y_equals_9() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(0, 9);
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_For_Negative_X_Values() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(-1, 0);
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_For_Negative_Y_Values() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(5, -1);
        assertFalse(isValidPosition);
    }

    @Test
    public void testAddPiece_True_For_Empty_Square() {
        when(testPawn.getXCoordinate()).thenReturn(0);
        when(testPawn.getYCoordinate()).thenReturn(0);
        boolean pieceAdded = testSubject.addPiece(testPawn);
        assertTrue(pieceAdded);
    }

    @Test
    public void testAddPiece_False_For_Occupied_Square() {
        when(testPawn.getXCoordinate()).thenReturn(0);
        when(testPawn.getYCoordinate()).thenReturn(0);
        testSubject.addPiece(testPawn);
        boolean pieceAdded = testSubject.addPiece(testPawn);
        assertFalse(pieceAdded);
    }

    @Test
    public void testLimits_The_Number_Of_Pawns() {
        when(testPawn.getXCoordinate()).thenReturn(0,1,2,3,4,5,6,7,0,1);
        when(testPawn.getYCoordinate()).thenReturn(0,0,0,0,0,0,0,0,1,1);
        for (int i = 0; i < 10; i++) {
            boolean piecePlaced = testSubject.addPiece(testPawn);
            if(i < 8) {
                assertTrue(piecePlaced);
            }
            else {
                assertFalse(piecePlaced);
            }
        }
    }
}