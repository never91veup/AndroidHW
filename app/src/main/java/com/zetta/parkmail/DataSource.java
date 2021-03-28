package com.zetta.parkmail;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;


public class DataSource {

    private static final DataSource ourInstance = new DataSource();
    private final List<NewsModel> list;
    private int currentNumber;


    public void elementAdd() {
        String numberBig = currentNumber + "";

        int colorfirst = Color.RED;
        int colorsecond = Color.BLUE;

        int color = (currentNumber % 2 == 0) ? colorfirst : colorsecond;

        currentNumber++;

        list.add(new NewsModel(numberBig, color));
    }

    private DataSource() {
        list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            String number = i + 1 + "";
            currentNumber = i + 2;
            int colorfirst = Color.RED;
            int colorsecond = Color.BLUE;

            int color = (i % 2 == 0) ? colorsecond : colorfirst;

            list.add(new NewsModel(number, color));
        }
    }

    static public DataSource getInstance() {
        return ourInstance;
    }

    public List<NewsModel> getData() {
        return list;
    }
}
