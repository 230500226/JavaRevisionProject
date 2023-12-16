import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdvancedCalculator extends Application {
    private TextField display;

    private double num1 = 0;
    private String operator = "";
    private boolean startNewInput = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Advanced Calculator");

        // Create the grid for the calculator layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(8);

        // Create the display field
        display = new TextField();
        display.setPromptText("0");
        display.setMinWidth(280);
        display.setMaxWidth(280);
        display.setEditable(false);
        GridPane.setConstraints(display, 0, 0, 4, 1);

        // Create numeric buttons
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };
        int row = 1;
        int col = 0;

        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setMinSize(70, 70);
            button.setOnAction(e -> handleButtonClick(label));
            GridPane.setConstraints(button, col, row);

            col++;
            if (col > 3) {
                col = 0;
                row++;
            }

            grid.getChildren().add(button);
        }

        grid.getChildren().addAll(display);

        Scene scene = new Scene(grid, 280, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(String value) {
        if (startNewInput) {
            display.clear();
            startNewInput = false;
        }

        if (value.matches("[0-9.]")) {
            display.appendText(value);
        } else if (value.matches("[+\\-*/]")) {
            if (!operator.isEmpty()) {
                calculate();
            }
            operator = value;
            num1 = Double.parseDouble(display.getText());
            startNewInput = true;
        } else if (value.equals("=")) {
            calculate();
            operator = "";
        }
    }

    private void calculate() {
        double num2 = Double.parseDouble(display.getText());
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    display.setText("Error");
                    startNewInput = true;
                    return;
                }
                break;
        }

        display.setText(String.valueOf(result));
        startNewInput = true;
    }
}
