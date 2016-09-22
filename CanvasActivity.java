package edu.temple.lab_3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);


        setContentView(R.layout.activity_canvas);
        Intent intent = getIntent();
        String message = intent.getStringExtra(PaletteActivity.MESSAGE);
        System.out.println("Message" + message);






        if(message.equals("Red")){
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        }
        else if(message.equals("Blue")) {
            getWindow().getDecorView().setBackgroundColor(Color.BLUE);
        }
        else if (message.equals("Green")){
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }
        else if(message.equals("Yellow")) {
            getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
        }
        else{
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        }

    }
}
