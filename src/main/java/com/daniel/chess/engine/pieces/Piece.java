package com.daniel.chess.engine.pieces;

import com.daniel.chess.engine.Alliance;
import com.daniel.chess.engine.board.Board;
import com.daniel.chess.engine.board.Move;

import java.util.Collection;

public abstract class Piece {

    protected final int piecePosition;
    protected final Alliance pieceAlliance;
    protected final boolean isFirstMove;

    public Piece(final int piecePosition, final Alliance pieceAlliance){
        this.pieceAlliance = pieceAlliance;
        this.piecePosition = piecePosition;
        //todo
        this.isFirstMove = false;
    }

    public int getPiecePosition() {
        return this.piecePosition;
    }

    public Alliance getPieceAlliance() {
        return this.pieceAlliance;
    }

    public boolean isFirstMove(){
        return this.isFirstMove;
    }

    public abstract Collection<Move> calculateLegalMoves(final Board board);
}
