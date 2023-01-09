package com.daniel.chess.engine;

import com.daniel.chess.engine.board.Board;

public class JChess {

    public static void main(String[] args) {

        Board board = Board.createStandardBoard();
        System.out.println(board);

    }
}
