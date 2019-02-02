package com.rashikbhasingmail.test1;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * Created by rashik on 24/6/16.
 */
public class model implements Serializable{

    private static final long serialVersionUID = 1L;

    String name;
    String url;
    String des;
    int price;
    String dimension;
    ArrayList<String> arr;
    String delivery;
   // ArrayList<ArrayList<String>> urls;

    public model(String name, String url, int price, String des,String dimension,ArrayList<String> arr,String delivery){
            this.name = name;
            this.url = url;
            this.des = des;
            this.price = price;
            this.dimension=dimension;
            this.arr=arr;
            this.delivery=delivery;
            //this.urls.add(arr);
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDes() {
        return des;
    }

    public int getPrice() {
        return price;
    }

    public String getDimension(){ return dimension; }

    public ArrayList<String> getUrlList(){return arr; }

    public String getDelivery(){return delivery;}

}
