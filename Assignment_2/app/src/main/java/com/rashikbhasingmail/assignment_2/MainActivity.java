package com.rashikbhasingmail.assignment_2;

import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    int[] imgIds = {R.drawable.sample_0, R.drawable.sample_2, R.drawable.sample_3,R.drawable.sample_4,R.drawable.sample_1,R.drawable.sample_3};
   ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter adapter = new CustomAdapter(MainActivity.this);
        viewPager.setAdapter(adapter);

        GridView gridview = (GridView)findViewById(R.id.grid);
        gridview.setAdapter(new ImageAdapter(this));

        LinearLayout layout = (LinearLayout) findViewById(R.id.linear3);
        for (int i = 0; i < 6; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            //imageView.setPadding(0, 0, 0, 0);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), imgIds[i]));
           // imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            layout.addView(imageView);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }
}
