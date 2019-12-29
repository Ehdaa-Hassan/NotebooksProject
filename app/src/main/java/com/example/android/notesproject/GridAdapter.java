package com.example.android.notesproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    // DeclareVariables
    private Context context;
    private ArrayList<String> notebookNames;
    private ArrayList<Integer> notebookImages;
    LayoutInflater inflater;

    public GridAdapter(Context context,ArrayList<String> notebookNames, ArrayList<Integer> notebookImages) {
        this.context = context;
        this.notebookNames = notebookNames;
        this.notebookImages = notebookImages;
    }

    @Override
    public int getCount() {
        return notebookNames.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Declare Variables
         TextView notebook_name;
         ImageView notebook_image;
         inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.grid_item, parent, false);
        // Locate the TextViews in listview_item.xml
        notebook_name = (TextView) itemView.findViewById(R.id.notebook_name);
        // Locate the ImageView inlistview_item.xml
        notebook_image = (ImageView) itemView.findViewById(R.id.notebook_image);
        //Capture position and set to the TextViews
        notebook_name.setText(notebookNames.get(position));
        // Captureposition and set to the ImageView
            notebook_image.setImageResource(notebookImages.get(position));

        return itemView;
    }
}

