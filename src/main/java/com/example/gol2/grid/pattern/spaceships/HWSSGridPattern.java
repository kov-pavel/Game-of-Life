package com.example.gol2.grid.pattern.spaceships;

import com.example.gol2.grid.pattern.GridPattern;
import com.example.gol2.grid.pattern.stillLifes.TubGridPattern;

public class HWSSGridPattern extends GridPattern {
    public static final HWSSGridPattern INSTANCE = new HWSSGridPattern();

    private HWSSGridPattern() {
        super(10, 9);
    }

    @Override
    protected void initPattern() {
        this.pattern = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 1, 0, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
    }
}
