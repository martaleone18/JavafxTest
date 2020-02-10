/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.demofx.gui;

import it.tss.demofx.business.DbStore;
import it.tss.demofx.business.SongsStoreException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author tss
 */
public class NewSongController implements Initializable {

    @FXML
    private TextField txtTitolo;
    @FXML
    private TextField txtArtista;
    @FXML
    private TextField txtAlbum;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("initialize newSong controller...");
    }

    public void onSave() {
        try {
            DbStore.saveNewSong(txtTitolo.getText(), txtArtista.getText(), txtAlbum.getText());
            clearFields();
            Messages.showMessage("Song salvata correttamente", "", Alert.AlertType.INFORMATION);
        } catch (SongsStoreException ex) {
            Messages.showMessage(ex.getMessage(), "", Alert.AlertType.ERROR);
        }
    }

    private void clearFields() {
        txtTitolo.setText("");
        txtArtista.setText("");
        txtAlbum.setText("");
    }
}
