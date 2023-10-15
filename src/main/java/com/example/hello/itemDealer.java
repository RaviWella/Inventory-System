package com.example.hello;

public class itemDealer {

    private String dddname;
    private String dddbrand;
    private String dddprice;
    private String dddquantity;


    // creating constructor to the dealers details
    public itemDealer(String dddname, String dddbrand, String dddprice, String dddquantity) {
        this.dddname = dddname;
        this.dddbrand = dddbrand;
        this.dddprice = dddprice;
        this.dddquantity = dddquantity;
    }

    // create getters and setters
    public String getDddname() {
        return dddname;
    }

    public void setDddname(String dddname) {
        this.dddname = dddname;
    }

    public String getDddbrand() {
        return dddbrand;
    }

    public void setDddbrand(String dddbrand) {
        this.dddbrand = dddbrand;
    }

    public String getDddprice() {
        return dddprice;
    }

    public void setDddprice(String dddprice) {
        this.dddprice = dddprice;
    }

    public String getDddquantity() {
        return dddquantity;
    }

    public void setDddquantity(String dddquantity) {
        this.dddquantity = dddquantity;
    }
}
