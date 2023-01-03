package com.daniel.chess.engine.pieces;

import com.daniel.chess.engine.Alliance;
import com.daniel.chess.engine.board.Board;
import com.daniel.chess.engine.board.Move;

import java.util.List;

public abstract class Piece {

    protected final int piecePosition;
    protected final Alliance pieceAlliance;

    public Piece(final int piecePosition, final Alliance pieceAlliance){
        this.pieceAlliance = pieceAlliance;
        this.piecePosition = piecePosition;
    }

    public abstract List<Move> calculateLegalMoves(final Board board);
}
