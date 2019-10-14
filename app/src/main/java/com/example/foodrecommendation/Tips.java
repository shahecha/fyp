package com.example.foodrecommendation;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Tips extends AppCompatActivity {

    GridLayout gridLayout;

    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        g = (LinearLayout) findViewById(R.id.hcBtn);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tips.this,Tipscholestrol.class);
                startActivity(i);

            }
        });

        h = (LinearLayout) findViewById(R.id.dBtn);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tips.this,tipsdiabetes.class);
                startActivity(i);

            }
        });

        i = (LinearLayout) findViewById(R.id.gBtn);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tips.this,Tipsgout.class);
                startActivity(i);

            }
        });

       


        l = (LinearLayout) findViewById(R.id.bpBtn);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tips.this,Tipsbp.class);
                startActivity(i);

            }
        });

    }


}