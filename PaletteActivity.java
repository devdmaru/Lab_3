package edu.temple.lab_3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class PaletteActivity extends AppCompatActivity {
    public static String MESSAGE = "";
    boolean firstLoadSelection = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        // Creating a spinner for displaying the items.
        ListView listView = (ListView) findViewById(R.id.listView);
        // An arraylist will hold the items.
        ArrayList <Colour> colors = new ArrayList<>();
        // Adding the colours to the arraylist
        colors.add(new Colour("White"));
        colors.add(new Colour("Red"));
        colors.add(new Colour("Blue"));
        colors.add(new Colour("Green"));
        colors.add(new Colour("Yellow"));

        CustomAdapter adapter = new CustomAdapter(this,colors);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sendMessage(parent, position);
            }
        });

    }
    //Sending a string from the main activity to the secondary activity.
    public void sendMessage(AdapterView parent, int position) {
        Intent intent = new Intent(this, CanvasActivity.class);
        String message = ((Colour)parent.getItemAtPosition(position)).getName();
        intent.putExtra(MESSAGE, message);
        startActivity(intent);
    }


}
