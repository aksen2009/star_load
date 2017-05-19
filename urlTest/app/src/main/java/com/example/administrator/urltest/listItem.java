package com.example.administrator.urltest;

/**
 * Created by yh on 2017-05-16.
 */

public class listItem {
    private String title;
    private  String url;
    private  String date;

    public listItem(String title, String url, String date){
            this.title = title;
            this.url = url;
            this.date = date;
    }
    public String getTitle(){return this.title;}
    public String getUrl(){return this.url;}
    public  String getDate(){return this.date;}
}
