module com.example.gol2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gol2 to javafx.fxml;
    exports com.example.gol2;
    exports com.example.gol2.grid;
    opens com.example.gol2.grid to javafx.fxml;
    exports com.example.gol2.grid.pattern;
    opens com.example.gol2.grid.pattern to javafx.fxml;
    exports com.example.gol2.grid.cell;
    opens com.example.gol2.grid.cell to javafx.fxml;
    exports com.example.gol2.grid.pattern.stillLifes;
    opens com.example.gol2.grid.pattern.stillLifes to javafx.fxml;
    exports com.example.gol2.grid.pattern.oscillators;
    opens com.example.gol2.grid.pattern.oscillators to javafx.fxml;
}