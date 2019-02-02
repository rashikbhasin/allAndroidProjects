package com.rashikbhasingmail.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ListView list;
    LazyAdapter adapter;

    List<model> listData = new ArrayList<>();


    public final static String EXTRA_MESSAGE ="message";
  //  String strJson="{ \"Data\" :[{\"Desc\":\"This is 1st desc and so on...So hello there\",\"name\":\"Sonoo Jaiswal\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/084/251/original/christmas-bokeh-vector-background.jpg\"},{\"Desc\":\"this is 2nd Description...whats up...how u doing\",\"name\":\"Vimal Jaiswal\",\"url\":\"https://image.freepik.com/free-photo/lens-flare-abstract-backgound_21276999.jpg\"},{\"Desc\":\"this is 3rd Description...random desc...\",\"name\":\"Rashik Bhasin\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/093/720/original/vector-abstract-style-background-illustration.jpg\"},{\"Desc\":\"This is also a desc and so on...So hello there\",\"name\":\"Sonoo Jaiswal\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/084/251/original/christmas-bokeh-vector-background.jpg\"},{\"Desc\":\"this is 4th Description...whats up...how u doing\",\"name\":\"Vimal Jaiswal\",\"url\":\"https://image.freepik.com/free-photo/lens-flare-abstract-backgound_21276999.jpg\"},{\"Desc\":\"this is 5th Description...random desc...\",\"name\":\"Rashik Bhasin\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/093/720/original/vector-abstract-style-background-illustration.jpg\"},{\"Desc\":\"This is 6th desc and so on...So hello there\",\"name\":\"Sonoo Jaiswal\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/084/251/original/christmas-bokeh-vector-background.jpg\"},{\"Desc\":\"this is 7th Description...whats up...how u doing\",\"name\":\"Vimal Jaiswal\",\"url\":\"https://image.freepik.com/free-photo/lens-flare-abstract-backgound_21276999.jpg\"},{\"Desc\":\"this is 8th Description...random desc...\",\"name\":\"Rashik Bhasin\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/093/720/original/vector-abstract-style-background-illustration.jpg\"},{\"Desc\":\"This is 9th desc and so on...So hello there\",\"name\":\"Sonoo Jaiswal\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/084/251/original/christmas-bokeh-vector-background.jpg\"},{\"Desc\":\"this is 10th Description...whats up...how u doing\",\"name\":\"Vimal Jaiswal\",\"url\":\"https://image.freepik.com/free-photo/lens-flare-abstract-backgound_21276999.jpg\"},{\"Desc\":\"this is 11th Description...random desc...\",\"name\":\"Rashik Bhasin\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/093/720/original/vector-abstract-style-background-illustration.jpg\"},{\"Desc\":\"This is 12th desc and so on...So hello there\",\"name\":\"Sonoo Jaiswal\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/084/251/original/christmas-bokeh-vector-background.jpg\"},{\"Desc\":\"this is 13th Description...whats up...how u doing\",\"name\":\"Vimal Jaiswal\",\"url\":\"https://image.freepik.com/free-photo/lens-flare-abstract-backgound_21276999.jpg\"},{\"Desc\":\"this is 15th Description...random desc...\",\"name\":\"Rashik Bhasin\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/093/720/original/vector-abstract-style-background-illustration.jpg\"},{\"Desc\":\"This is 16th desc and so on...So hello there\",\"name\":\"Sonoo Jaiswal\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/084/251/original/christmas-bokeh-vector-background.jpg\"},{\"Desc\":\"this is 17th Description...whats up...how u doing\",\"name\":\"Vimal Jaiswal\",\"url\":\"https://image.freepik.com/free-photo/lens-flare-abstract-backgound_21276999.jpg\"},{\"Desc\":\"this is 18th Description...random desc...\",\"name\":\"Rashik Bhasin\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/093/720/original/vector-abstract-style-background-illustration.jpg\"},{\"Desc\":\"This is 19th desc and so on...So hello there\",\"name\":\"Sonoo Jaiswal\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/084/251/original/christmas-bokeh-vector-background.jpg\"},{\"Desc\":\"this is 20th Description...whats up...how u doing\",\"name\":\"Vimal Jaiswal\",\"url\":\"https://image.freepik.com/free-photo/lens-flare-abstract-backgound_21276999.jpg\"},{\"Desc\":\"this is 21st Description...random desc...\",\"name\":\"Rashik Bhasin\",\"url\":\"http://static.vecteezy.com/system/resources/previews/000/093/720/original/vector-abstract-style-background-illustration.jpg\"}] }";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listData= Utils.createListData();
//        try {
//        JSONObject jsonRootObject = new JSONObject(strJson);
            // JSONArray jsonArray = jsonRootObject.optJSONArray("Data");


        list = (ListView) findViewById(R.id.listView1);
        adapter=new LazyAdapter(this, listData);

//        adapter = new LazyAdapter(this, jsonRootObject);
        list.setAdapter(adapter);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                model data=listData.get(i);

              // String s=""+data.name+","+data.price+","+data.des+","+data.url;
                Intent intent=new Intent(MainActivity.this,Second_activity.class);
                intent.putExtra("mylist",data);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onDestroy()
    {
        list.setAdapter(null);
        super.onDestroy();
    }




}
