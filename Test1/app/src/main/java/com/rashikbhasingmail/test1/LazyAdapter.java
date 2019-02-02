package com.rashikbhasingmail.test1;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class LazyAdapter extends BaseAdapter {

    private Activity context;
    //private String[] data;

    List<model> listData;

    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader;

    public LazyAdapter(Activity context,  List<model> listData) {
        this.context = context;
        this.listData = listData;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(context.getApplicationContext());
    }

    public int getCount() {
        return listData.size();
    }

    public model getItem(int position) {
        return listData.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.row_listview_item, null);

        TextView text=(TextView)vi.findViewById(R.id.text);

        TextView text1=(TextView)vi.findViewById(R.id.text1);

        TextView text2=(TextView)vi.findViewById(R.id.text2);

        ImageView image=(ImageView)vi.findViewById(R.id.image);
        model data = getItem(position);
        text.setText("Name:"+data.getName());
        text1.setText("Price:" + data.getPrice());
        text2.setText(data.getDes());
        imageLoader.DisplayImage(data.getUrl(), image);

        return vi;
    }
}
