package com.example.touchpoints;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.touchpoints.R;

public class MainActivity extends AppCompatActivity {
    //    TextView name,x,y;
//    EditText type,xlocation,ylocation;
//    Button submitbtn;
    private boolean isTouch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        name = (TextView) findViewById(R.id.actionname);
//        x = (TextView) findViewById(R.id.xaxisname);
//        y = (TextView) findViewById(R.id.yaxisname);
//        type = (EditText) findViewById(R.id.actiontype);
//        xlocation = (EditText) findViewById(R.id.xtype);
//        ylocation = (EditText) findViewById(R.id.ytype);
//        submitbtn = (Button) findViewById(R.id.submitbtn);


    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int X = (int) event.getX();
        int Y = (int) event.getY();
        int eventAction = event.getAction();
        switch (eventAction) {
            case MotionEvent.ACTION_DOWN:
//                on action down change the text of the action type to action down
//                type.setText("ACTION_DOWN");
//                xlocation.setText(X);
//                ylocation.setText(Y);
//                Toast.makeText(this, "ACTION_DOWN "+"X: "+X+" Y: "+Y, Toast.LENGTH_SHORT).show();


                isTouch = true;
                break;
//            case MotionEvent.ACTION_MOVE:
////                on action move change the text of the action type to action move
////                type.setText("MOVE");
////                xlocation.setText(X);
////                ylocation.setText(Y);
//                Toast.makeText(this, "MOVE "+"X: "+X+" Y: "+Y,
//                        Toast.LENGTH_SHORT).show();
//                break;

//                when the finger is raised
            case MotionEvent.ACTION_UP:
//                on action up change the text of action type to action up
//                type.setText("ACTION_UP");
//                xlocation.setText(X);
//                ylocation.setText(Y);
                Toast.makeText(this, "touch point "+"X: "+X+" Y: "+Y, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, VerifyPoints.class);
                intent.putExtra("action", "Tap");
                intent.putExtra("xcordinates", X);
                intent.putExtra("ycordinates", Y);
                startActivity(intent);
                break;

        }
        return true;
    }
}
