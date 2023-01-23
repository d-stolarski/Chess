package com.daniel.chess.engine.player.ai;

import com.daniel.chess.engine.board.Board;

public interface BoardEvaluator {

    int evaluate(Board board, int depth);
}