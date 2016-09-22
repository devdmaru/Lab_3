package edu.temple.lab_3;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dev on 9/21/16.
 */
public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Colour> items;

    public CustomAdapter(Context c, ArrayList<Colour> items){
        this.c = c;
        this.items = items;
    }

    @Override
    public int getCount() {

        return items.size();
    }

    @Override
    public Object getItem(int position) {

        return items.get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }
    // Setting the custom adapter to hold the views
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layout;

       if(convertView != null){
           layout = (LinearLayout) convertView;
           TextView colorName = (TextView) layout.getChildAt(0);


           colorName.setText(items.get(position).getName());

       } else{
           layout = new LinearLayout(c);
           layout.setOrientation(LinearLayout.VERTICAL);
           TextView nameTextView = new TextView(c);


           nameTextView.setText(items.get(position).getName());
           nameTextView.setTextSize(30);
           nameTextView.setMaxWidth(500);
           nameTextView.setTextColor(android.graphics.Color.BLACK);
           nameTextView.setBackgroundColor(getColor(position));

           layout.addView(nameTextView);

       }

        return layout;
    }
    // Returns an integer value for the string value of the colour.
    public int getColor(int position){

        if(items.get(position).getName().equals("Red")){
            return Color.RED;
        }
        else if(items.get(position).getName().equals("Blue")){
            return Color.BLUE;
        }
        else if(items.get(position).getName().equals("Green")){
            return Color.GREEN;
        }
        else if(items.get(position).getName().equals("White")){
            return Color.WHITE;
        }
        return Color.YELLOW;
    }


}
