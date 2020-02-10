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
import java.util.List;


/**
 *
 * @author tss
 */
public class ListSongController implements Initializable {
    
    @FXML
    private TableView table = new TableView();
    @FXML
    private TableColumn<String, Songs> columntitle;
    @FXML
    private TableColumn<String, Songs> columnauthor;
    @FXML
    private TableColumn<String, Songs> columnalbum;
    
    private List<Songs> canzoni = new ArrayList<>();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        System.out.println("initialize ListSongController....");
        table.setEditable(true);
        columntitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnauthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        columnalbum.setCellValueFactory(new PropertyValueFactory<>("album"));
        table.getColumns().addAll("title", "author","album");
        
        

    }

    
   public List <Songs> viewAllSongs(String title, String author, String album){
        canzoni = new ArrayList<Songs>();
        try (Connection cn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/songs","tss","ghiglieno"); Statement cmd = cn.createStatement();) {

            ResultSet rs = cmd.executeQuery("select * from song");
            while (rs.next()) {
                
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return canzoni;
    }
        
}  
       
    

