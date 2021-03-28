package com.zetta.parkmail;

public class NewsModel {


    private final String number;
    private int color;

    public NewsModel(String number, int color) {
        this.number = number;
        this.color = color;

    }

    public NewsModel(String numberBig) {
        this.number = numberBig;
    }

    public String getNumberList() {
        return number;
    }

    public int getColor() {
        return color;
    }

}

