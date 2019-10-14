package com.example.foodrecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Introduction extends AppCompatActivity {
    private LinearLayout aa;
    private LinearLayout bb;
    private LinearLayout cc;
    private LinearLayout dd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        aa = (LinearLayout) findViewById(R.id.bpintro);
        aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Introduction.this,Introbp.class);
                startActivity(i);

            }
        });

        bb = (LinearLayout) findViewById(R.id.hcintro);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Introduction.this,Introhc.class);
                startActivity(i);

            }
        });

        cc = (LinearLayout) findViewById(R.id.dintro);
        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Introduction.this,introdiabetes.class);
                startActivity(i);

            }
        });
        dd = (LinearLayout) findViewById(R.id.gintro);
        dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Introduction.this,Introgout.class);
                startActivity(i);

            }
        });
    }
}
