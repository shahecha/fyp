package com.example.foodrecommendation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (Button) findViewById(R.id.continueBtn);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Mainpage.class);
                startActivity(i);

            }
        });

        Toast.makeText(MainActivity.this, "Firebase Connection Success", Toast.LENGTH_LONG).show();


    }

}
