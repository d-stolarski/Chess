package com.daniel.chess.engine.player;

import com.daniel.chess.engine.Alliance;
import com.daniel.chess.engine.board.Board;
import com.daniel.chess.engine.board.Move;
import com.daniel.chess.engine.pieces.King;
import com.daniel.chess.engine.pieces.Piece;

import java.util.Collection;

public abstract class Player {

    protected final Board board;
    protected final King playerKing;
    protected final Collection<Move> legalMoves;

    public Player(final Board board,
                  final Collection<Move> legalMoves,
                  final Collection<Move> opponentMoves) {
        this.board = board;
        this.playerKing = establishKing();
        this.legalMoves = legalMoves;
    }

    private King establishKing() {
        for(final Piece piece : getActivePieces()) {
            if(piece.getPieceType().isKing()){
                return (King) piece;
            }
        }
        throw new RuntimeException("Not a valid board!");
    }

    public abstract Collection<Piece> getActivePieces();
    public abstract Alliance getAlliance();
    public abstract Player getOpponent();


}
