package com.example.frigeralt.taskproject.RecyclerItems;


public class Article {
    private String title;
    private String description;
    private int imageID;

    public Article(String title, String description, int imageID) {
        this.title = title;
        this.description = description;
        this.imageID = imageID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageID() {
        return imageID;
    }
}
