package com.example.gol2.grid.cell;

import javafx.scene.paint.Color;

public class Cell {
    private Coord coord;
    private Color color;
    private LiveCondition liveCondition;

    public Cell(Coord coord, Color color, LiveCondition liveCondition) {
        this.coord = coord;
        this.color = color;
        this.liveCondition = liveCondition;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public LiveCondition getLiveCondition() {
        return liveCondition;
    }

    public void setLiveCondition(LiveCondition liveCondition) {
        this.liveCondition = liveCondition;
    }
}
