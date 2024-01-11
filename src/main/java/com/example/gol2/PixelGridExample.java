package com.example.gol2;

import com.example.gol2.grid.Grid;
import com.example.gol2.grid.pattern.EmptyGridPattern;
import com.example.gol2.grid.pattern.GridPattern;
import com.example.gol2.grid.pattern.MomoGridPattern;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PixelGridExample extends Application {

    private static Grid grid;

    private final Runnable GoLRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    Thread.sleep(5);
                    grid.makeLogic();
                    grid.redraw();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };


    @Override
    public void start(Stage primaryStage) {
        GridPattern[][] gridPatterns = new GridPattern[][] {
                //{BlockGridPattern.INSTANCE, RPentominoGridPattern.INSTANCE, GliderGridPattern.INSTANCE},
                //{PulsarGridPattern.INSTANCE, BlinkerGridPattern.INSTANCE, HWSSGridPattern.INSTANCE},
                //{RPentominoGridPattern.INSTANCE, RPentominoGridPattern.INSTANCE, RPentominoGridPattern.INSTANCE},
                {EmptyGridPattern.INSTANCE, EmptyGridPattern.INSTANCE, EmptyGridPattern.INSTANCE},
                {EmptyGridPattern.INSTANCE, MomoGridPattern.INSTANCE, EmptyGridPattern.INSTANCE},
        };
        grid = new Grid(gridPatterns);

        primaryStage.setTitle("Pixel Grid Example");
        primaryStage.setScene(new Scene(grid, Utils.WIDTH, Utils.HEIGHT));
        primaryStage.show();

        // I was lazy for the searching how to switch pixels on scene in runtime for JavaFX correctly
        // So I just run another thread in the current one with that logic
        // I assume this is a bad practice to do that but
        new Thread(GoLRunnable).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
