package com.example.booklibrary;

public class BOOKS {
    int id;
   String Name;
   String Author;
    int Pages;
    String Imageurl;
    String Description;

    public BOOKS(int id, String name, String author, int pages, String imageurl, String description) {
        this.id = id;
        Name = name;
        Author = author;
        Pages = pages;
        Imageurl = imageurl;
        Description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getPages() {
        return Pages;
    }

    public void setPages(int pages) {
        Pages = pages;
    }

    public String getImageurl() {
        return Imageurl;
    }

    public void setImageurl(String imageurl) {
        Imageurl = imageurl;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "BOOKS{" +
                "Name='" + Name + '\'' +
                ", Author='" + Author + '\'' +
                ", Pages=" + Pages +
                ", Imageurl='" + Imageurl + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
