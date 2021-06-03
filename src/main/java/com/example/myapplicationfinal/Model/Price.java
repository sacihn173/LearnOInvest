package com.example.myapplicationfinal.Model;

public class Price {
    private int id;
//    private String name ;
    private String price;

    public Price( String price) {       //String name
//        this.name = name;
        this.price = price;
    }

    public Price(int id, String price ){      //String name,
        this.id = id;
//        this.name = name;
        this.price = price;
    }



    public Price(){ }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}


