package com.ivan.androidfanny.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2016/11/2.
 */

public class Book extends DataSupport {
    private String name;
    private float price;
    private Author author;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
