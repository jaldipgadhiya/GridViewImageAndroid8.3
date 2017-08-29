package com.android.acadgild.gridviewimageandroid;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView androidGridView;
    // Array of Images
    Integer[] imageIDs = {
            R.drawable.android_gingerbread, R.drawable.honeycomb, R.drawable.is,
            R.drawable.jellybean, R.drawable.kitkat, R.drawable.lolipop,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        androidGridView = (GridView) findViewById(R.id.gridView);
        //Setting Adapter to Grid View by creating object of ImageAdapterGridView class
        androidGridView.setAdapter(new ImageAdapterGridView(this));

        // Setting On Item Click Listner to Display Toast
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                Toast.makeText(getBaseContext(), "Grid Item " + (position + 1) + " Selected", Toast.LENGTH_LONG).show();
            }
        });
    }

    //Class to set Image Adapter Grid View
    public class ImageAdapterGridView extends BaseAdapter {


        private Context mContext;
        //Constructor
        public ImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIDs.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }



        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView(mContext);
                //Setting Layout Parameters
                mImageView.setLayoutParams(new GridView.LayoutParams(130, 130));
                mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //Setting Height & Width of Imageview
                mImageView.getLayoutParams().width = 510;
                mImageView.getLayoutParams().height = 510;
                //Setting Background color for Imageview to display borders
                mImageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                //Setting padding for Imageview
                mImageView.setPadding(16, 16, 16, 16);
            } else {
                mImageView = (ImageView) convertView;
                //Setting Background color for Imageview to display borders
                mImageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                //Setting Height & Width of Imageview
                mImageView.getLayoutParams().width = 510;
                mImageView.getLayoutParams().height = 510;
            }
            mImageView.setImageResource(imageIDs[position]);
            return mImageView;
        }
    }



}



