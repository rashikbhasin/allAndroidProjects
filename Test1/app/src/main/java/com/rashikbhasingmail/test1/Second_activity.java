package com.rashikbhasingmail.test1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.io.InputStream;
import java.util.ArrayList;

public class Second_activity extends AppCompatActivity {

    ViewPager viewPager;
    PagerAdapter adapter;
    public ImageLoader imageLoader;

    private String imageUrls[] = {  "http://previews.123rf.com/images/jezper/jezper1310/jezper131000007/23210182-Abstract-sphere-made-of-3d-cubes--Stock-Photo-data-big-concept.jpg",
            "http://previews.123rf.com/images/chernetskiy/chernetskiy0908/chernetskiy090800032/5358264-Big-monochrome-gray-cube-made-of-smaller-cubes-in-process-of-destruction-on-white-background-Stock-Photo.jpg",
            "http://previews.123rf.com/images/chernetskiy/chernetskiy0908/chernetskiy090800014/5358271-Gray-cube-made-of-smaller-cubes-of-same-size-and-color-on-white-background-Stock-Photo.jpg",
            "http://previews.123rf.com/images/experimental/experimental1002/experimental100200010/6349232-block-of-dirty-white-cube-with-drop-shadow-Stock-Vector-cube-cubes-grid.jpg",
            "http://previews.123rf.com/images/cre8tive/cre8tive0609/cre8tive060900103/520188-Big-cube-broken-down-into-smaller-cubes-Stock-Photo.jpg"
    };


    LinearLayout layout;

    private class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public ImageDownloader(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            Bitmap bitmap = null;
            try {
                InputStream in = new java.net.URL(url).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("MyApp", e.getMessage());
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        Intent intent=getIntent();

        model data = (model) intent.getSerializableExtra("mylist");
        ArrayList<String> list=data.getUrlList();
        String[] urls=new String[list.size()];

        for(int i=0;i<urls.length;i++)
        {
            urls[i]=list.get(i);
        }

        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(Second_activity.this, urls);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);

        TextView t1=(TextView)findViewById(R.id.text1);
        t1.setText(data.getName());

        TextView t2=(TextView)findViewById(R.id.text2);
        t2.setText(data.getPrice()+"");

        TextView t3=(TextView)findViewById(R.id.text222);
        t3.setText(data.getDimension());

        TextView t4=(TextView)findViewById(R.id.text333);
        t4.setText(data.getDelivery());

        GridView gridview = (GridView)findViewById(R.id.grid);
        gridview.setNumColumns(8);
        gridview.setAdapter(new ImageAdapter(this));


        layout = (LinearLayout) findViewById(R.id.imageGallery);
        for (int i = 0; i < imageUrls.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(500, 500);
            imageView.setLayoutParams(layoutParams);


            ImageDownloader imageDownLoader = new ImageDownloader(imageView);
            imageDownLoader.execute(imageUrls[i]);

            layout.addView(imageView);
        }

    }


}

