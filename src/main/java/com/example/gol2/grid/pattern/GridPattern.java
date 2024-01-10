package com.example.gol2.grid.pattern;

public abstract class GridPattern {
    protected int width;
    protected int height;
    protected int[][] pattern;

    protected GridPattern(int width, int height) {
        this.width = width;
        this.height = height;

        initPattern();
    }

    protected abstract void initPattern();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getPattern() {
        return pattern;
    }
}
