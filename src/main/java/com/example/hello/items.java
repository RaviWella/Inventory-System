package com.example.hello;

public class items {
    int item_code;
    String item_name;

    String item_brand;

    double item_Price;

    int item_quantity;

    String item_category;

    String picturePath;

    String date;


    // create a constructor
    public items(int item_code, String item_name, String item_brand, double item_Price, int item_quantity, String item_category, String date) {
        this.item_code = item_code;
        this.item_name = item_name;
        this.item_brand = item_brand;
        this.item_Price = item_Price;
        this.item_quantity = item_quantity;
        this.item_category = item_category;
        this.date = date;
    }

    public items(int item_code, String item_name, String item_brand, double item_Price, int item_quantity, String item_category, String picturePath, String date) {
        this.item_code = item_code;
        this.item_name = item_name;
        this.item_brand = item_brand;
        this.item_Price = item_Price;
        this.item_quantity = item_quantity;
        this.item_category = item_category;
        this.picturePath = picturePath;
        this.date = date;
    }

    // create getters and setters
    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public int getItem_code() {
        return item_code;
    }

    public void setItem_code(int item_code) {
        this.item_code = item_code;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_brand() {
        return item_brand;
    }

    public void setItem_brand(String item_brand) {
        this.item_brand = item_brand;
    }

    public double getItem_Price() {
        return item_Price;
    }

    public void setItem_Price(double item_Price) {
        this.item_Price = item_Price;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
