package com.example.gol2.grid.pattern;

public class EmptyGridPattern extends GridPattern {
    public static final EmptyGridPattern INSTANCE = new EmptyGridPattern();

    private EmptyGridPattern() {
        super(0, 0);
    }

    @Override
    protected void initPattern() {
        this.pattern = new int[][]{};
    }
}
