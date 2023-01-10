package com.daniel.chess.engine.player;

import com.daniel.chess.engine.board.Board;
import com.daniel.chess.engine.board.Move;
import com.daniel.chess.engine.pieces.Piece;

import java.util.Collection;

public class WhitePlayer extends Player{

    public WhitePlayer(Board board,
                       Collection<Move> whiteStandardLegalMoves,
                       Collection<Move> blackStandardLegalMoves) {
        super(board, whiteStandardLegalMoves, blackStandardLegalMoves);
    }

    @Override
    public Collection<Piece> getActivePieces() {
        return this.board.getWhitePieces();
    }
}
