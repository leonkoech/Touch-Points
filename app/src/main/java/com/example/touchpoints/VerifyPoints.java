package com.example.touchpoints;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.touchpoints.R;
import com.example.touchpoints.TouchPoints;

public class VerifyPoints extends AppCompatActivity {
    Button nextpage;
    EditText touchtype,xcord,ycord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_points);
        nextpage=findViewById(R.id.submitbtn);
        touchtype=findViewById(R.id.actiontype);
        xcord=findViewById(R.id.xtype);
        ycord=findViewById(R.id.ytype);

        Intent intent = getIntent();
        //get the attached extras from the intent
        //we should use the same key as we used to attach the data.
        final String action = intent.getStringExtra("action");
        //if you have used any other type of data, you should use the
        //particular getExtra method to extract the data from Intet
        final Integer xcordinates = intent.getIntExtra("xcordinates",0);
        final Integer ycordinates = intent.getIntExtra("ycordinates",0);

//        now set the edit text values to the ones you obtained from intent

        touchtype.setText(action);
        xcord.setText(Integer.toString(xcordinates));
        ycord.setText(Integer.toString(ycordinates));

        nextpage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View _view) {
                Intent i = new Intent(VerifyPoints.this, TouchPoints.class);
                i.putExtra("action", action);
                i.putExtra("xcordinates", xcordinates);
                i.putExtra("ycordinates", ycordinates);
                startActivity(i);
            }


        });
    }
}
