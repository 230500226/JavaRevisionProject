import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AdvancedCalendar extends Application {
    private LocalDate currentDate;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        currentDate = LocalDate.now();

        primaryStage.setTitle("Advanced Calendar");

        GridPane gridPane = createCalendar(currentDate);

        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private GridPane createCalendar(LocalDate date) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        int year = date.getYear();
        int month = date.getMonthValue();

        gridPane.add(new Button("<<"), 0, 0);
        gridPane.add(new Button("<"), 1, 0, 2, 1);
        gridPane.add(new Button(">>"), 3, 0);

        gridPane.add(new Button("January"), 1, 1, 2, 1);

        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        for (int i = 0; i < 7; i++) {
            gridPane.add(new Button(daysOfWeek[i]), i, 2);
        }

        int startDay = date.withDayOfMonth(1).getDayOfWeek().getValue();
        int daysInMonth = date.lengthOfMonth();

        int row = 3;
        int col = startDay;

        for (int day = 1; day <= daysInMonth; day++) {
            Button dayButton = new Button(Integer.toString(day));
            dayButton.setMinSize(50, 50);
            gridPane.add(dayButton, col, row);

            col++;
            if (col > 6) {
                col = 0;
                row++;
            }
        }

        return gridPane;
    }
}
