package com.example.gol2.grid.pattern.spaceships;

import com.example.gol2.grid.pattern.GridPattern;
import com.example.gol2.grid.pattern.stillLifes.BlockGridPattern;

public class GliderGridPattern extends GridPattern {
    public static final GliderGridPattern INSTANCE = new GliderGridPattern();

    private GliderGridPattern() {
        super(6, 6);
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
