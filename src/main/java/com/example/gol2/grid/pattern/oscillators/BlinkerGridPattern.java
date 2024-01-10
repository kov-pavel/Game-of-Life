package com.example.gol2.grid.pattern.oscillators;

import com.example.gol2.grid.pattern.GridPattern;

public class BlinkerGridPattern extends GridPattern {

    public static final BlinkerGridPattern INSTANCE = new BlinkerGridPattern();

    private BlinkerGridPattern() {
        super(5, 5);
    }

    @Override
    protected void initPattern() {
        this.pattern = new int[][] {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
    }
}
