package com.rashikbhasingmail.scroll_using_view_pager;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends Activity {

    // Declare Variables
    ViewPager viewPager;
    PagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from viewpager_main.xml
        setContentView(R.layout.activity_main);

        // Generate sample data

        String[] urls={  "https://www.smashingmagazine.com/images/nature-wallpapers/22.jpg",
                "https://www.zotks.si/sites/default/files/nature_040.jpg",
                "https://www.colourbox.com/preview/4188354-tropical-park-nature-background.jpg"};

        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(MainActivity.this, urls);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);

    }
}
