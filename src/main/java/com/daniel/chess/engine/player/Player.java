package com.daniel.chess.engine.player;

import com.daniel.chess.engine.Alliance;
import com.daniel.chess.engine.board.Board;
import com.daniel.chess.engine.board.Move;
import com.daniel.chess.engine.pieces.King;
import com.daniel.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.daniel.chess.engine.pieces.Piece.PieceType.KING;
import static java.util.stream.Collectors.collectingAndThen;

public abstract class Player {

    protected final Board board;
    protected final King playerKing;
    protected final Collection<Move> legalMoves;
    protected final boolean isInCheck;

    public Player(final Board board,
                  final Collection<Move> playerLegals,
                  final Collection<Move> opponentLegals) {
        this.board = board;
        this.playerKing = establishKing();
        this.isInCheck = !calculateAttacksOnTile(this.playerKing.getPiecePosition(),
                opponentLegals).isEmpty();
        playerLegals.addAll(calculateKingCastles(playerLegals, opponentLegals));
        this.legalMoves = Collections.unmodifiableCollection(playerLegals);
    }

    public boolean isInCheck() {
        return this.isInCheck;
    }

    public boolean isInCheckMate() {
        return this.isInCheck && !hasEscapeMoves();
    }

    public boolean isInStaleMate() {
        return !this.isInCheck && !hasEscapeMoves();
    }

    public boolean isCastled() {
        return false;
    }

    public boolean isKingSideCastleCapable() {
        return this.playerKing.isKingSideCastleCapable();
    }

    public boolean isQueenSideCastleCapable() {
        return this.playerKing.isQueenSideCastleCapable();
    }

    public King getPlayerKing() {
        return this.playerKing;
    }

    private King establishKing() {
        return (King) getActivePieces().stream()
                .filter(piece -> piece.getPieceType() == KING)
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    private boolean hasEscapeMoves() {
      return this.legalMoves.stream()
              .anyMatch(move -> makeMove(move)
              .getMoveStatus().isDone());
    }

    public Collection<Move> getLegalMoves() {
        return this.legalMoves;
    }

    static Collection<Move> calculateAttacksOnTile(final int tile,
                                                   final Collection<Move> moves) {
        return moves.stream()
                .filter(move -> move.getDestinationCoordinate() == tile)
                .collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public boolean isMoveLegal(final Move move) {
        return this.legalMoves.contains(move);
    }

    public MoveTransition makeMove(final Move move) {
        if(!isMoveLegal(move)) {
            return new MoveTransition(this.board, move, MoveStatus.ILLEGAL_MOVE);
        }
        final Board transitionBoard = move.execute();
        final Collection<Move> kingAttacks = Player.calculateAttacksOnTile(transitionBoard.currentPlayer().
                getOpponent().getPlayerKing().getPiecePosition(), transitionBoard.currentPlayer().getLegalMoves());
        if(!kingAttacks.isEmpty()) {
            return new MoveTransition(this.board, move, MoveStatus.LEAVES_PLAYER_IN_CHECK);
        }
        return new MoveTransition(transitionBoard, move, MoveStatus.DONE);
    }

    public abstract Collection<Piece> getActivePieces();
    public abstract Alliance getAlliance();
    public abstract Player getOpponent();
    protected abstract Collection<Move> calculateKingCastles(Collection<Move> playerLegals,
                                                             Collection<Move> opponentsLegals);
}
