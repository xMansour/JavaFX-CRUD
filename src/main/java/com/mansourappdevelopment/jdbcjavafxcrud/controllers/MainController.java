package com.mansourappdevelopment.jdbcjavafxcrud.controllers;

import com.mansourappdevelopment.jdbcjavafxcrud.models.Book;
import com.mansourappdevelopment.jdbcjavafxcrud.models.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MainController {
    @FXML
    public TableView<Book> booksTable;
    @FXML
    public TableColumn<Book, Integer> idColumn;
    @FXML
    public TableColumn<Book, String> titleColumn;
    @FXML
    public TableColumn<Book, String> authorColumn;
    @FXML
    public TableColumn<Book, String> yearColumn;
    @FXML
    public TableColumn<Book, Integer> pagesColumn;

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
    public void initialize() throws SQLException {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        pagesColumn.setCellValueFactory(new PropertyValueFactory<>("pages"));

        onReadClicked();
        //booksTable.setPlaceholder(
        //      new Label("No rows to display"));
    }


    public void onCreateClicked() throws SQLException {
        Database.create(new Book(null, titleInput.getText(), authorInput.getText(), yearInput.getText(), Integer.parseInt(pagesInput.getText())));
    }


    public void onUpdateClicked() throws SQLException {
        Database.update(new Book(Integer.parseInt(idInput.getText()), titleInput.getText(), authorInput.getText(), yearInput.getText(), Integer.parseInt(pagesInput.getText())));

    }

    public void onDeleteClicked() throws SQLException {
        Database.delete(Integer.parseInt(idInput.getText()));
    }

    public void onCommitClicked() throws SQLException {
        Database.commit();
    }

    public void onRollbackClicked() throws SQLException {
        Database.rollback();
    }

    public void onReadClicked() throws SQLException {
        ObservableList<Book> data = FXCollections.observableArrayList();
        ResultSet resultSet = Database.read();
        while (resultSet.next()) {
            data.add(new Book(Integer.parseInt(resultSet.getString("id")), resultSet.getString("title"),
                    resultSet.getString("author"), resultSet.getString("year"),
                    Integer.parseInt(resultSet.getString("pages"))));
        }
        booksTable.setItems(data);
    }

    public void onTruncateClicked() throws SQLException {
        Database.truncate();
    }
}