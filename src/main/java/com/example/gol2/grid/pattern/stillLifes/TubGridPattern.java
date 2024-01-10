package com.example.gol2.grid.pattern.stillLifes;

import com.example.gol2.grid.pattern.GridPattern;
import com.example.gol2.grid.pattern.spaceships.GliderGridPattern;

public class TubGridPattern extends GridPattern {
    public static final TubGridPattern INSTANCE = new TubGridPattern();

    private TubGridPattern() {
        super(5, 5);
    }

    @Override
    protected void initPattern() {
        this.pattern = new int[][] {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
        };
    }
}
