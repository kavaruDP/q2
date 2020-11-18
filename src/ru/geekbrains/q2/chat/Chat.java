package ru.geekbrains.q2.chat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.LinkedHashMap;
import java.util.Map;

public class Chat {
    @FXML
    private TextField inputField;
    @FXML
    private ListView<String> listView;
    @FXML
    private MenuItem exitMenu;

    @FXML
    public void initialize() {

    }
    @FXML
    public void addWord() {
        String word = inputField.getText();
        addWordToList(word);
    }
    @FXML
    public void exitApp() {
        System.exit(0);
    }

    public void addWordToList(String word) {
        if (word.length()!=0) {
            listView.getItems().add(word);

        }
        inputField.setText("");
    }
}
