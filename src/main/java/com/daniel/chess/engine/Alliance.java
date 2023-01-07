package com.daniel.chess.engine;

public enum Alliance {
    WHITE {
        @Override
        int getDirection() {
            return -1;
        }
    },
    BLACK {
        @Override
        int getDirection() {
            return 1;
        }
    };

    abstract int getDirection();
}
