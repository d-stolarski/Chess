package com.daniel.chess.pgn;

import com.daniel.chess.engine.board.Board;

public class FenUtilities {

    private FenUtilities() {
        throw new RuntimeException("Not Instatiable");
    }

    public static Board createGameFromFEN(final String fenString) {
        return parseFEN(fenString);
    }

}
