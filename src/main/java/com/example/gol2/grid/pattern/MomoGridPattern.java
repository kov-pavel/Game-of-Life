package com.example.gol2.grid.pattern;

public class MomoGridPattern extends GridPattern {
    public static final MomoGridPattern INSTANCE = new MomoGridPattern();

    private MomoGridPattern() {
        super(11, 11);
    }

    @Override
    protected void initPattern() {
        this.pattern = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
    }
}
