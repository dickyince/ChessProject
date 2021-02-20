package com.solarwindsmsp.chess;

public class Pawn extends Piece{

    private ChessBoard chessBoard;

    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void move(MovementType movementType, int newX, int newY) {
        throw new UnsupportedOperationException("Need to implement Pawn.Move()") ;
    }
}
