package com.example.gol2.grid;

import com.example.gol2.Utils;
import com.example.gol2.grid.cell.Cell;
import com.example.gol2.grid.cell.Coord;
import com.example.gol2.grid.cell.LiveCondition;
import com.example.gol2.grid.pattern.GridPattern;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid extends BorderPane {

    private Cell[][] grid = new Cell[Utils.WIDTH / Utils.PIXEL_SIZE][Utils.HEIGHT / Utils.PIXEL_SIZE];
    private final GridPattern[][] gridPatterns;
    private final Canvas canvas;

    public Grid(GridPattern[][] gridPatterns) {
        this.gridPatterns = gridPatterns;

        canvas = new Canvas(Utils.WIDTH, Utils.HEIGHT);
        this.setCenter(canvas);

        initGrid();
        redraw();
    }

    private void initGrid() {
        for (int gridY = 0; gridY < grid.length; gridY++) {
            for (int gridX = 0; gridX < grid[0].length; gridX++) {
                for (int patternY = 0; patternY < gridPatterns.length; patternY++) {
                    for (int patternX = 0; patternX < gridPatterns[0].length; patternX++) {
                        GridPattern gridPattern = gridPatterns[patternY][patternX];

                        int gridPatternHeight = gridPattern.getHeight();
                        int gridPatternWidth = gridPattern.getWidth();
                        int[][] gridPatternAr = gridPattern.getPattern();

                        int shiftX = 20 * patternX;
                        int shiftY = 20 * patternY;

                        if (gridY < gridPatternHeight && gridX < gridPatternWidth && gridPatternAr[gridY][gridX] > 0) {
                            grid[gridY + shiftY][gridX + shiftX] = new Cell(new Coord(gridX + shiftX, gridY + shiftY), Color.BLACK, LiveCondition.LIVE);
                        } else if (grid[gridY][gridX] == null) {
                            grid[gridY][gridX] = new Cell(new Coord(gridX, gridY), Color.WHITE, LiveCondition.DEAD);
                        }
                    }
                }
            }
        }
    }

    public void redraw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, Utils.WIDTH, Utils.HEIGHT);
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                gc.setFill(grid[y][x].getColor());
                gc.fillRect(x * Utils.PIXEL_SIZE, y * Utils.PIXEL_SIZE, Utils.PIXEL_SIZE, Utils.PIXEL_SIZE);
            }
        }
    }

    // We have to make a decision about live status of each cell concurrently
    // So there we just make a grid copy that be modified and after the modifying replace existing grid by new one
    public void makeLogic() {
        Cell[][] newGrid = new Cell[Utils.WIDTH / Utils.PIXEL_SIZE][Utils.HEIGHT / Utils.PIXEL_SIZE];

        Arrays.stream(grid).flatMap(Arrays::stream).forEach(cell -> {
            Coord coord = cell.getCoord();
            int x = coord.x();
            int y = coord.y();
            int nLiveNeighbors = countLiveNeighbors(x, y);

            if (LiveCondition.LIVE.equals(cell.getLiveCondition())
                    && (nLiveNeighbors < 2 || nLiveNeighbors > 3)) {
                newGrid[y][x] = new Cell(coord, Color.WHITE, LiveCondition.DEAD);
            } else if (LiveCondition.DEAD.equals(cell.getLiveCondition())
                    && nLiveNeighbors == 3) {
                newGrid[y][x] = new Cell(coord, Color.BLACK, LiveCondition.LIVE);
            } else {
                newGrid[y][x] = cell;
            }
        });

        grid = newGrid;
    }

    private int countLiveNeighbors(int x, int y) {
        List<Cell> neighbors = getNeighbors(x, y);

        return (int) neighbors
                .stream()
                .filter(cell -> LiveCondition.LIVE.equals(cell.getLiveCondition()))
                .count();
    }

    private List<Cell> getNeighbors(int x, int y) {
        List<Cell> neighbors = new ArrayList<>();
        addTopNeighbors(neighbors, x, y);
        addLeftRightNeighbors(neighbors, x, y);
        addBottomNeighbors(neighbors, x, y);
        return neighbors;
    }

    private void addTopNeighbors(List<Cell> neighbors, int x, int y) {
        if (y > 0) {
            int topY = y - 1;

            if (x > 0) {
                neighbors.add(grid[topY][x-1]);
            }

            neighbors.add(grid[topY][x]);

            if (x < grid[0].length - 1) {
                neighbors.add(grid[topY][x+1]);
            }
        }
    }

    private void addLeftRightNeighbors(List<Cell> neighbors, int x, int y) {
        if (x > 0) {
            neighbors.add(grid[y][x-1]);
        }

        if (x < grid[0].length - 1) {
            neighbors.add(grid[y][x+1]);
        }
    }

    private void addBottomNeighbors(List<Cell> neighbors, int x, int y) {
        if (y < grid.length - 1) {
            int bottomY = y + 1;

            if (x > 0) {
                neighbors.add(grid[bottomY][x-1]);
            }

            neighbors.add(grid[bottomY][x]);

            if (x < grid[0].length - 1) {
                neighbors.add(grid[bottomY][x+1]);
            }
        }
    }
}
