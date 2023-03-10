package com.daniel.chess.engine.player.ai;

import com.daniel.chess.engine.board.Board;
import com.daniel.chess.engine.board.Move;

public interface MoveStrategy {

    long getNumBoardsEvaluated();

    Move execute(Board board);

}
