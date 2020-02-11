/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.demofx.gui;

import it.tss.demofx.business.Songs;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import it.tss.demofx.business.DbStore;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tss
 */
public class ListSongController implements Initializable {

    @FXML
    TableView table = new TableView();
    @FXML
    TableColumn columntitle;
    @FXML
    TableColumn columnauthor;
    @FXML
    TableColumn columnalbum;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        System.out.println("initialize ListSongController....");
        columntitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnauthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        columnalbum.setCellValueFactory(new PropertyValueFactory<>("album"));

    }

    public void onShow() throws SQLException {

        DbStore.viewAllSongs().forEach(c -> table.getItems().add(c));
        System.out.println("avviato");

    }

}
