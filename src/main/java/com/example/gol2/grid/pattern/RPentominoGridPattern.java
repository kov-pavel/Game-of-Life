package com.example.gol2.grid.pattern;

public class RPentominoGridPattern extends GridPattern {
    public static final RPentominoGridPattern INSTANCE = new RPentominoGridPattern();

    private RPentominoGridPattern() {
        super(5, 5);
    }

    @Override
    protected void initPattern() {
        this.pattern = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
        };
    }
}
