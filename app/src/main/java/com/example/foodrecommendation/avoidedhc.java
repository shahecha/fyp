package com.example.foodrecommendation;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

import java.util.ArrayList;
import java.util.List;


public class avoidedhc extends AppCompatActivity {

    Button button;
    ListView lv;
    FirebaseListAdapter adapter;
    FoodAdapter adapterFood;
    private DatabaseReference query;


    String[] listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avoidedhc);


        final ArrayList<foodconst> snapshotListData =  new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("hyperlipidemia").child("avoided").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                if(dataSnapshot.exists())
                {
                    for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        if(dataSnapshot1.exists())
                        {
                            for(DataSnapshot dataSnapshot2 : dataSnapshot1.getChildren())
                            {
                                if (dataSnapshot2.exists())
                                {
                                    foodconst fc = dataSnapshot2.getValue(foodconst.class);
                                    snapshotListData.add(fc);
                                    adapterFood.notifyDataSetChanged();
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        button = findViewById(R.id.buttonfilter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItems = new String[]{"Grains", "Fruit","Vegetable", "Protein", "Fat","Sugar","Dairy","Others"};
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(avoidedhc.this);
                mBuilder.setTitle("Hyperlipidemia: avoided food");
                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        if (i == 0)
                        {
                            Intent j = new Intent(avoidedhc.this,avoidedhcgrains.class);
                            startActivity(j);
                        }

                        if (i == 1)
                        {

                            Intent j = new Intent(avoidedhc.this,avoidedhcfruit.class);
                            startActivity(j);
                        }
                        if (i == 2)
                        {

                            Intent j = new Intent(avoidedhc.this,avoidedhcvegetables.class);
                            startActivity(j);
                        }
                        if (i == 3)
                        {

                            Intent j = new Intent(avoidedhc.this,avoidedhcprotein.class);
                            startActivity(j);
                        }
                        if (i == 4)
                        {

                            Intent j = new Intent(avoidedhc.this,avoidedhcfat.class);
                            startActivity(j);
                        }
                        if (i ==5)
                        {

                            Intent j = new Intent(avoidedhc.this,avoidedhcsugar.class);
                            startActivity(j);
                        }
                        if (i ==6)
                        {

                            Intent j = new Intent(avoidedhc.this,avoidedhcdairy.class);
                            startActivity(j);
                        }
                        if (i ==7)
                        {

                            Intent j = new Intent(avoidedhc.this,avoidedhcothers.class);
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
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();

            }
        });

        lv = (ListView) findViewById(R.id.listView);
        adapterFood = new FoodAdapter(this,0,snapshotListData);
        lv.setAdapter(adapterFood);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }
}



