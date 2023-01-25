package com.daniel.chess;

import com.daniel.chess.engine.board.Board;
import com.daniel.chess.gui.Table;

public class JChess {

    public static void main(String[] args) {

        Board board = Board.createStandardBoard();
        System.out.println(board);

        Table.get().show();

    }
}
