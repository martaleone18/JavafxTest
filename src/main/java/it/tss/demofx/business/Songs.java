/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.demofx.business;

import java.util.Objects;

/**
 *
 * @author tss
 */
public class Songs {

    private String title;
    private String author;
    private String album;

    public Songs(String title, String author, String album) {
        this.title = title;
        this.author = author;
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.title);
        hash = 31 * hash + Objects.hashCode(this.author);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Songs other = (Songs) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Songs{" + "title=" + title + ", author=" + author + ", album=" + album + '}';
    }

   
    

}
