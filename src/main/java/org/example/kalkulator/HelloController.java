package org.example.kalkulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloController {
    @FXML
    public Button buttonSave;
    @FXML
    public Button buttonClear;
    @FXML
    public Button buttonMultiply;
    @FXML
    public Button buttonDivide;
    @FXML
    private ListView<String> listOfOperations;
    @FXML
    private Button buttonMinus;

    @FXML
    private Button buttonPlus;

    @FXML
    private Label labelNumber1;

    @FXML
    private Label labelNumber2;

    @FXML
    private Label labelResult;

    @FXML
    private Label labelTitle;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private TextField textNumber1;

    @FXML
    private TextField textNumber2;
    @FXML
    void handleCalculation(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String id = btn.getId();

        try {
            double liczba1 = Double.parseDouble(textNumber1.getText());
            double liczba2 = Double.parseDouble(textNumber2.getText());
            double wynik = 0;
            switch(id) {
                case "buttonMinus":
                    wynik = liczba1 - liczba2;
                    labelResult.setText(liczba1 + " - " + liczba2 + " = " + wynik);
                    break;
                case "buttonPlus":
                    wynik = liczba1 + liczba2;
                    labelResult.setText(liczba1 + " + " + liczba2 + " = " + wynik);
                    break;
                case "buttonMultiply":
                    wynik = liczba1 * liczba2;
                    labelResult.setText(liczba1 + " * " + liczba2 + " = " + wynik);
                    break;
                case "buttonDivide":
                    wynik = liczba1 / liczba2;
                    if (liczba2 == 0) {
                        labelResult.setText("Nie dziel przez zero!");
                        return;
                    }
                    labelResult.setText(liczba1 + " / " + liczba2 + " = " + wynik);
                    break;
                default:
                    // code block
            }
            listOfOperations.getItems().add(textNumber1.getText() + " - " + textNumber2.getText() + " = " + wynik);
        } catch (NumberFormatException e) {
            labelResult.setText("Błąd konwersji");
        }
    }

    @FXML
    void onMinus(ActionEvent event) {
        handleCalculation(event);
    }

    @FXML
    void onPlus(ActionEvent event) {
        handleCalculation(event);
    }

    @FXML
    void onMultiply(ActionEvent event) {
        handleCalculation(event);
    }

    @FXML
    void onDivide(ActionEvent event) {
        handleCalculation(event);
    }

    @FXML
    void onClear(ActionEvent actionEvent) {
        listOfOperations.getItems().clear();
        labelResult.setText("");
    }

    @FXML
    void onSave(ActionEvent actionEvent) {
        if (listOfOperations.getItems().size() == 0) {
            labelResult.setText("Brak danych do zapisania");
            return;
        }

        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Plik tekstowy", "*.txt"));
            File file = fileChooser.showSaveDialog(new Stage());

            if (file != null) {
                PrintWriter output = new PrintWriter(file.getAbsolutePath() + ".txt");
                output.println("Zapisane operacje:");
                for (String s : listOfOperations.getItems()) {
                    output.println(s);
                }
                output.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}




