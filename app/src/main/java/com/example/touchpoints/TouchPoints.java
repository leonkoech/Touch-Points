package com.example.touchpoints;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.touchpoints.R;

public class TouchPoints extends AppCompatActivity {
    // this is where the touches appear
    LinearLayout view;
    Canvas canvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_points);
        view=findViewById(R.id.mainview);
        view.setWillNotDraw(false);

        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event)
            {
                int X = (int) event.getX();
                int Y = (int) event.getY();

//                do whatever you want with the touched coordinates here

//                the x,y here are the two points that have been sent by the
//                first activity and also have been tapped on this page



                Toast toast = Toast.makeText(
                        getApplicationContext(),
                        "final touch point "+"X: "+X+" Y: "+Y,
                        Toast.LENGTH_LONG

                );
                toast.show();

                return true;
            }
        });

        Intent intent = getIntent();
        //get the attached extras from the intent
        //we should use the same key as we used to attach the data.
        String action = intent.getStringExtra("action");
        //if you have used any other type of data, you should use the
        //particular getExtra method to extract the data from Intet
        Integer xcordinates = intent.getIntExtra("xcordinates",0);
        Integer ycordinates = intent.getIntExtra("ycordinates",0);
        // Obtain MotionEvent object
        long downTime = SystemClock.uptimeMillis();
        long eventTime = SystemClock.uptimeMillis() + 100;
        float x = xcordinates;
        float y = ycordinates;
        // List of meta states found here: developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
        int metaState = 0;
        MotionEvent motionEvent = MotionEvent.obtain(
                downTime,
                eventTime,
                MotionEvent.ACTION_UP,
                x,
                y,
                metaState
        );

// Dispatch touch event to view
        view.dispatchTouchEvent(motionEvent);
    }

}
