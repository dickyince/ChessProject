package com.solarwindsmsp.chess;

public class Pawn extends Piece{

    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
    }

    public boolean move(int newX, int newY) {
        throw new UnsupportedOperationException("Need to implement Pawn.Move()") ;
    }
}
