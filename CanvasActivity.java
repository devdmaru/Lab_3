package edu.temple.lab_3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        // Getting intent from the main activity
        Intent intent = getIntent();
        // Getting the message from the main activity.
        String message;

        if((message = intent.getStringExtra(PaletteActivity.MESSAGE)) == null) {
            message = "White";
        }

        // Checking to see if the message matches a string, and then setting the color of the secondary activity.
        if(message.equals("Red") || message.equals("Rojo")){
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        }
        else if(message.equals("Blue") || message.equals("Azul")) {
            getWindow().getDecorView().setBackgroundColor(Color.BLUE);
        }
        else if (message.equals("Green") || message.equals("Verde")){
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }
        else if(message.equals("Yellow") || message.equals("Amarillo")) {
            getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
        }
        else{
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        }

    }
}
