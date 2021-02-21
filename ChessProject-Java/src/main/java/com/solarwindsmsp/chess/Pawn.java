package com.solarwindsmsp.chess;

public class Pawn extends Piece{

    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
    }

    public boolean move(int newX, int newY) {
        if(getChessBoard() == null) {
            return false;
        }
        if(newX < 0 || newX > 7) {
            return false;
        }
        if(newY < 0 || newY > 7) {
            return false;
        }
        if(newX != getXCoordinate()) {
            return false;
        }
        if(newY > getYCoordinate()) {
            return false;
        }
        if(newX == getXCoordinate() && newY == getYCoordinate()) {
            return false;
        }
        if(getYCoordinate() - newY > 1) {
            return false;
        }
        boolean moved = getChessBoard().isLegalBoardPosition(newX, newY);
        if(moved) {
            setXCoordinate(newX);
            setYCoordinate(newY);
        }
        return moved;
    }
}
