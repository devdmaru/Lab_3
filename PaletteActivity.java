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
import android.widget.Spinner;

import java.util.ArrayList;

public class PaletteActivity extends Activity {
    public static String MESSAGE = "";
    boolean firstLoadSelection = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        // Creating a spinner for displaying the items.
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // An arraylist will hold the items.
        ArrayList <Colour> colors = new ArrayList<>();
        // Adding the colours to the arraylist
        colors.add(new Colour("White"));
        colors.add(new Colour("Red"));
        colors.add(new Colour("Blue"));
        colors.add(new Colour("Green"));
        colors.add(new Colour("Yellow"));

        CustomAdapter adapter = new CustomAdapter(this,colors);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!firstLoadSelection) {
                    sendMessage(parent, position);

                }
                firstLoadSelection = false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
