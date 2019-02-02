package com.rashikbhasingmail.asynchronous_image_loading;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView list;
    LazyAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView)findViewById(R.id.listView1);
        adapter=new LazyAdapter(this, imageUrls);
        list.setAdapter(adapter);
    }

    @Override
    public void onDestroy()
    {
        list.setAdapter(null);
        super.onDestroy();
    }

    private String imageUrls[] = {
            "http://static.vecteezy.com/system/resources/previews/000/084/251/original/christmas-bokeh-vector-background.jpg",
            "https://image.freepik.com/free-photo/lens-flare-abstract-backgound_21276999.jpg",
            "http://static.vecteezy.com/system/resources/previews/000/093/720/original/vector-abstract-style-background-illustration.jpg",
            "http://elektrodomek.pl/wp-content/uploads/2015/05/lights__vector_background_by_colorsark-d53prik.jpg"

    };
}
