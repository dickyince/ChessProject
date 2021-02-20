package com.solarwindsmsp.chess;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChessBoardTest extends TestCase {

    // Class under test
    private ChessBoard testSubject;

    // Mocks used for test
    private Piece testPiece;

    @Before
    public void setUp() {
        testSubject = new ChessBoard();
        testPiece = mock(Piece.class);
    }

    @Test
    public void testHas_MaxBoardWidth_of_7() {
        assertEquals(7, ChessBoard.MAX_BOARD_HEIGHT);
    }

    @Test
    public void testHas_MaxBoardHeight_of_7() {
        assertEquals(7, ChessBoard.MAX_BOARD_HEIGHT);
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
        when(testPiece.getXCoordinate()).thenReturn(0);
        when(testPiece.getYCoordinate()).thenReturn(0);
        boolean pieceAdded = testSubject.addPiece(testPiece);
        assertTrue(pieceAdded);
    }

    @Test
    public void testAddPiece_False_For_Occupied_Square() {
        when(testPiece.getXCoordinate()).thenReturn(0);
        when(testPiece.getYCoordinate()).thenReturn(0);
        testSubject.addPiece(testPiece);
        boolean pieceAdded = testSubject.addPiece(testPiece);
        assertFalse(pieceAdded);
    }

    @Test
    public void testLimits_The_Number_Of_Pawns() {
        when(testPiece.getXCoordinate()).thenReturn(0,1,2,3,4,5,6,7,0,1);
        when(testPiece.getYCoordinate()).thenReturn(0,0,0,0,0,0,0,0,1,1);
        for (int i = 0; i < 10; i++) {
            boolean piecePlaced = testSubject.addPiece(testPiece);
            if(i < 8) {
                assertTrue(piecePlaced);
            }
            else {
                assertFalse(piecePlaced);
            }
        }
    }
}