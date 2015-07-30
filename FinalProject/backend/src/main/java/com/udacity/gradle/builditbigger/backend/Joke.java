package com.udacity.gradle.builditbigger.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class Joke {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}
