package com.rashikbhasingmail.assignment_1;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //     int[] imgIds = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,R.drawable.image_4,R.drawable.image_1,R.drawable.image_3};
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter adapter = new CustomAdapter(MainActivity.this);
        viewPager.setAdapter(adapter);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

//        LinearLayout layout = (LinearLayout) findViewById(R.id.linear3);
//        for (int i = 0; i < 6; i++) {
//            ImageView imageView = new ImageView(this);
//            imageView.setId(i);
//            imageView.setPadding(2, 2, 2, 2);
//            imageView.setImageBitmap(BitmapFactory.decodeResource(
//                    getResources(),imgIds[i] ));
//           imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            layout.addView(imageView);
//         }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
