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
    public Button buttonSave;
    public Button buttonClear;
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
    void onMinus(ActionEvent event) {
        try {
            double liczba1 = Double.parseDouble(textNumber1.getText());
            double liczba2 = Double.parseDouble(textNumber2.getText());
            double wynik = liczba1 - liczba2;
            labelResult.setText(liczba1 + " - " + liczba2 + " = " + wynik);
            listOfOperations.getItems().add(textNumber1.getText() + " - " + textNumber2.getText() + " = " + wynik);
        } catch (NumberFormatException e) {
            labelResult.setText("Błąd konwersji");
        }
    }

    @FXML
    void onPlus(ActionEvent event) {
        try {
            double liczba1 = Double.parseDouble(textNumber1.getText());
            double liczba2 = Double.parseDouble(textNumber2.getText());
            double wynik = liczba1 + liczba2;
            labelResult.setText(liczba1 + " + " + liczba2 + " = " + wynik);
            listOfOperations.getItems().add(textNumber1.getText() + " + " + textNumber2.getText() + " = " + wynik);
        } catch (NumberFormatException e) {
            labelResult.setText("Błąd konwersji");
        }
    }

    @FXML
    void onClear(ActionEvent actionEvent) {
        listOfOperations.getItems().clear();
    }

    @FXML
    void onSave(ActionEvent actionEvent) {
        try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(new Stage());
            if (file != null) {
                PrintWriter output = new PrintWriter(file.getAbsolutePath());
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




