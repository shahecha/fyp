package com.example.foodrecommendation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import android.widget.TextView;
public class Illness extends AppCompatActivity {

    String[] listItems;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout s;
    private LinearLayout h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illness);

        e = (LinearLayout) findViewById(R.id.diabetes);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems=new String[]{"Suggested food","Avoided food"};
                final AlertDialog.Builder mBuilder=new AlertDialog.Builder(Illness.this);
                mBuilder.setTitle("Diabetes");
                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i==0)
                        {
                            Intent j = new Intent(Illness.this,suggesteddiabetes.class);
                            startActivity(j);
                        }

                        if(i==1)
                        {
                            Intent j = new Intent(Illness.this,avoideddiabetes.class);
                            startActivity(j);
                        }
                    }
                });
                mBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                //show alert dialog
                AlertDialog mDialog=mBuilder.create();
                mDialog.show();

            }
        });

        f = (LinearLayout) findViewById(R.id.bp);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems=new String[]{"Suggested food","Avoided food"};
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(Illness.this);
                mBuilder.setTitle("Hypertension");
                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i==0)
                        { Intent j = new Intent(Illness.this,suggestedhypertension.class);
                            startActivity(j);}
                        if(i==1)
                        { Intent j = new Intent(Illness.this,avoidedhypertension.class);
                            startActivity(j);}

                    }
                });
                mBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                //show alert dialog
                AlertDialog mDialog=mBuilder.create();
                mDialog.show();

            }
        });

        s = (LinearLayout) findViewById(R.id.hc);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems=new String[]{"Suggested food","Avoided food"};
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(Illness.this);
                mBuilder.setTitle("Hyperlipidemia");
                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i==0)
                        { Intent j = new Intent(Illness.this,suggestedhc.class);
                            startActivity(j);}
                        if(i==1)
                        { Intent j = new Intent(Illness.this,avoidedhc.class);
                            startActivity(j);}

                    }
                });
                mBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                //show alert dialog
                AlertDialog mDialog=mBuilder.create();
                mDialog.show();

            }
        });

        h = (LinearLayout) findViewById(R.id.gout);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems=new String[]{"Suggested food","Avoided food"};
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(Illness.this);
                mBuilder.setTitle("Gout");
                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i==0)
                        { Intent j = new Intent(Illness.this,suggestedgout.class);
                            startActivity(j);}
                        if(i==1)
                        { Intent j = new Intent(Illness.this,avoidedgout.class);
                            startActivity(j);}

                    }
                });
                mBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                //show alert dialog
                AlertDialog mDialog=mBuilder.create();
                mDialog.show();

            }
        });



    }
}
