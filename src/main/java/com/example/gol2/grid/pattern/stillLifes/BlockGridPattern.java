package com.example.gol2.grid.pattern.stillLifes;

import com.example.gol2.grid.pattern.GridPattern;

public class BlockGridPattern extends GridPattern {

    public static final BlockGridPattern INSTANCE = new BlockGridPattern();

    private BlockGridPattern() {
        super(4, 4);
    }

    @Override
    protected void initPattern() {
        this.pattern = new int[][] {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };
    }
}
