package com.mansourappdevelopment.jdbcjavafxcrud.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private TextField idInput;
    @FXML
    private TextField titleInput;
    @FXML
    private TextField authorInput;
    @FXML
    private TextField yearInput;
    @FXML
    private TextField pagesInput;
    @FXML
    private Button createBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button commitBtn;
    @FXML
    private Button rollbackBtn;
    @FXML
    private TableColumn idColumn;
    @FXML
    private TableColumn titleColumn;
    @FXML
    private TableColumn authorColumn;
    @FXML
    private TableColumn yearColumn;
    @FXML
    private TableColumn pagesColumn;

    public void onCreateClicked(ActionEvent actionEvent) {

    }


    public void onUpdateClicked(ActionEvent actionEvent) {
    }

    public void onDeleteClicked(ActionEvent actionEvent) {
    }

    public void onCommitClicked(ActionEvent actionEvent) {
    }

    public void onRollbackClicked(ActionEvent actionEvent) {
    }
}