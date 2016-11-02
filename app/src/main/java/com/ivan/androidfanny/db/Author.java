package com.ivan.androidfanny.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2016/11/2.
 */
public class Author extends DataSupport {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
