package com.rashikbhasingmail.list_imageurl_adapter;


import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

import android.widget.ListView;

public class MainActivity extends Activity {

    ListView lv;
    Context context;

    public static String[] prgmImages={"http://static.vecteezy.com/system/resources/previews/000/084/251/original/christmas-bokeh-vector-background.jpg",
    "https://image.freepik.com/free-photo/lens-flare-abstract-backgound_21276999.jpg",
    "http://static.vecteezy.com/system/resources/previews/000/093/720/original/vector-abstract-style-background-illustration.jpg",
    "http://elektrodomek.pl/wp-content/uploads/2015/05/lights__vector_background_by_colorsark-d53prik.jpg"};

    public static String [] prgmNameList={"Image 1 jkdlf","Image 2 asdf","Image 3 Yes","Image 4 Hello"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));

    }


}