package com.example.foodrecommendation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Mainpage extends AppCompatActivity {

    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        e = (LinearLayout) findViewById(R.id.introBtn);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this,Introduction.class);
                startActivity(i);

            }
        });

        f = (LinearLayout) findViewById(R.id.foodBtn);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this,Illness.class);
                startActivity(i);

            }
        });

        s = (LinearLayout) findViewById(R.id.tipsBtn);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this,Tips.class);
                startActivity(i);

            }
        });



    }
}
