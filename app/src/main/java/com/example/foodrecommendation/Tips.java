package com.example.foodrecommendation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Tips extends AppCompatActivity {

    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout s;
    private LinearLayout h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        e = (LinearLayout) findViewById(R.id.diabetes);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tips.this,tipsdiabetes.class);
                startActivity(i);

            }
        });

        f = (LinearLayout) findViewById(R.id.bp);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tips.this,Tipsbp.class);
                startActivity(i);

            }
        });

        s = (LinearLayout) findViewById(R.id.hc);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tips.this,Tipscholestrol.class);
                startActivity(i);

            }
        });

        h = (LinearLayout) findViewById(R.id.gout);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tips.this,Tipsgout.class);
                startActivity(i);

            }
        });



    }
}
