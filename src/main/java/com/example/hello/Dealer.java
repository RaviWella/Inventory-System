package com.example.hello;

import javafx.beans.property.SimpleStringProperty;

public class Dealer {

    private String dealerID;
    private String dealerName;
    private String phone;
    private String location;

    @Override
    public String toString() {
        return "Dealer ID: " + dealerID + ", Dealer Name: " + dealerName + ", Phone: " + phone + ", Location: " + location;
    }

    // create constructor
    public Dealer(String dealerID, String dealerName, String phone, String location) {
        this.dealerID = dealerID;
        this.dealerName = dealerName;
        this.phone = phone;
        this.location = location;
    }

    // create getters and setters
    public String getDealerID() {

        return dealerID;
    }

    public void setDealerID(String dealerID) {
        this.dealerID = dealerID;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

