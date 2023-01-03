package com.daniel.chess.engine.pieces;

import com.daniel.chess.engine.Alliance;

public class Piece {

    protected final int piecePosition;
    protected final Alliance pieceAlliance;

    public Piece(final int piecePosition, final Alliance pieceAlliance){
        this.pieceAlliance = pieceAlliance;
        this.piecePosition = piecePosition;
    }

    public abstract List<Move> calculateLegalMoves(final Board board);
}
