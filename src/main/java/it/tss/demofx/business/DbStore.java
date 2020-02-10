/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.demofx.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

/**
 *
 * @author tss
 */
public class DbStore {

    private static final String URL = "jdbc:mariadb://localhost:3306/songs";
    private static final String USR = "tss";
    private static final String PWD = "ghiglieno";
    


    public static void saveNewSong(String titolo, String artista, String album) {
        try (Connection cn = DriverManager.getConnection(URL, USR, PWD); PreparedStatement pcmd = cn.prepareStatement("INSERT INTO song (title, artist, album) "
                + "VALUES (?, ?, ?)");) {

            pcmd.setString(1, titolo);
            pcmd.setString(2, artista);
            pcmd.setString(3, album);
            pcmd.executeUpdate();
            debugPrintAllSongs();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            throw new SongsStoreException("Errore nel salvataggio della nuova song");
        }
    }

    private static void debugPrintAllSongs() {
        try (Connection cn = DriverManager.getConnection(URL, USR, PWD); Statement cmd = cn.createStatement();) {
            ResultSet rs = cmd.executeQuery("select * from song");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ","
                        + rs.getString("title")
                        + "," + rs.getString("artist"));
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }


}
