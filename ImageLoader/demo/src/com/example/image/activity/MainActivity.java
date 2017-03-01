package com.example.image.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.csdn.imageloader.ImageLoader;
import com.example.image.R;

public class MainActivity extends Activity implements View.OnClickListener {


    private android.widget.ListView testlist;
    ImageLoader mImageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.mai);
        this.testlist = (ListView) findViewById(R.id.testlist);
        mImageLoader = ImageLoader.getInstance(3, ImageLoader.Type.LIFO);
        testlist.setAdapter(new IamgeAdapter());

        //ImageLoader.getInstance(3, ImageLoader.Type.LIFO).loadImage("http://img.ivsky.com/img/tupian/pre/201611/25/weimei_de_haibian_riluo.jpg", teetiamge, true);

    }

    @Override
    public void onClick(View v) {

    }


    class IamgeAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null);
                viewHolder.img = (ImageView) convertView.findViewById(R.id.imgage);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            mImageLoader.loadImage("http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg", viewHolder.img, true);
            return convertView;
        }

        class ViewHolder {
            ImageView img;
        }
    }
}
