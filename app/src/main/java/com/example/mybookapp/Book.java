package com.example.mybookapp;

import com.google.firebase.firestore.Exclude;
import java.io.Serializable;

/*
public class Book implements Serializable{

    String title, author, comment;
    @Exclude private String id;

    public Book() {
    }

    public Book(String title, String author, String comment) {
        this.title = title;
        this.author = author;
        this.comment = comment;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    /*
    public Book(String title) {
        this.title = title;
    }

 */
public class Book {
    private String title;
    private String author;
    private String comment;
    private String documentID;

    public Book() {
        //public no-arg constructor needed
    }

    @Exclude
    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public Book(String title){
        this.title = title;
    }

    public Book(String title, String author, String comment) {
        this.title = title;
        this.author = author;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getComment() {
        return comment;
    }



}
