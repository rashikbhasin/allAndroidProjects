package com.rashikbhasingmail.horizontal_scroll_images;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private String imageUrls[] = {  "https://www.smashingmagazine.com/images/nature-wallpapers/22.jpg",
            "https://www.zotks.si/sites/default/files/nature_040.jpg",
            "https://www.colourbox.com/preview/4188354-tropical-park-nature-background.jpg"
    };

  //  private Integer images[] = {R.drawable.p1, R.drawable.p2, R.drawable.p3,R.drawable.p1, R.drawable.p2, R.drawable.p3,R.drawable.p1, R.drawable.p2, R.drawable.p3};


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
        setContentView(R.layout.activity_main);
      //  addImagesToThegallery();

//        final ImageView imageView = (ImageView) findViewById(R.id.img1);
//        ImageDownloader imageDownLoader = new ImageDownloader(imageView);
//        imageDownLoader.execute(imageUrls);
//        layout.addView(imageView);


        layout = (LinearLayout) findViewById(R.id.imageGallery);
        for (int i = 0; i < imageUrls.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1000, 1000);
            imageView.setLayoutParams(layoutParams);

           // imageView.requestLayout();
            //imageView.getLayoutParams().height=80;

            ImageDownloader imageDownLoader = new ImageDownloader(imageView);
            imageDownLoader.execute(imageUrls[i]);
          //  imageView.setImageBitmap(BitmapFactory.decodeResource(
          //          getResources(), R.drawable.ic_launcher));
          //  imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            layout.addView(imageView);
        }
    }
























 //   private void addImagesToThegallery() {
//        LinearLayout imageGallery = (LinearLayout) findViewById(R.id.imageGallery);
//        for (Integer image : images) {
//            imageGallery.addView(getImageView(image));
//        }
//    }


//    private View getImageView(Integer image) {
//        ImageView imageView = new ImageView(getApplicationContext());
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        lp.setMargins(0, 0, 10, 0);
//        imageView.setLayoutParams(lp);
//        imageView.setImageResource(image);
//        return imageView;
//    }
}
