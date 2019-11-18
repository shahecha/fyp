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


public class avoidedgout extends AppCompatActivity {


    Button button;
    ListView lv;
    FirebaseListAdapter adapter;
    FoodAdapter adapterFood;
    private DatabaseReference query;

    CharSequence[] items = { "Grains", "Vegetable", "Protein", "Legume","Others"};
    boolean[] selectedItems = { false, false, false, false,false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avoidedgout);

        final ArrayList<foodconst> snapshotListData =  new ArrayList<>();


        FirebaseDatabase.getInstance().getReference().child("gout").child("avoided").addValueEventListener(new ValueEventListener(){
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
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(avoidedgout.this);
                alertDialogBuilder.setCancelable(true);
                alertDialogBuilder.setTitle("Select Food Category");
                alertDialogBuilder.setMultiChoiceItems(items, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        selectedItems[which] = isChecked;
                    }
                });
                alertDialogBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        if (selectedItems[0] == true )
                        {
                            FirebaseDatabase.getInstance().getReference().child("gout").child("avoided").child("grains").addValueEventListener(new ValueEventListener(){
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.exists()) {
                                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                                        {
                                            if (dataSnapshot1.exists())
                                            {
                                                foodconst fc = dataSnapshot1.getValue(foodconst.class);
                                                snapshotListData.add(fc);
                                                adapterFood.notifyDataSetChanged();
                                            }
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) { }
                            });
                        }
                        else if (selectedItems[1] == true )
                        {
                            FirebaseDatabase.getInstance().getReference().child("gout").child("avoided").child("vegetables").addValueEventListener(new ValueEventListener(){
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.exists()) {
                                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                                        {
                                            if (dataSnapshot1.exists())
                                            {
                                                foodconst fc = dataSnapshot1.getValue(foodconst.class);
                                                snapshotListData.add(fc);
                                                adapterFood.notifyDataSetChanged();
                                            }
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) { }
                            });
                        }
                        else if (selectedItems[2] == true )
                        {
                            FirebaseDatabase.getInstance().getReference().child("gout").child("avoided").child("protein").addValueEventListener(new ValueEventListener(){
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.exists()) {
                                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                                        {
                                            if (dataSnapshot1.exists())
                                            {
                                                foodconst fc = dataSnapshot1.getValue(foodconst.class);
                                                snapshotListData.add(fc);
                                                adapterFood.notifyDataSetChanged();
                                            }
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) { }
                            });
                        }
                        else if (selectedItems[3] == true )
                        {
                            FirebaseDatabase.getInstance().getReference().child("gout").child("avoided").child("legume").addValueEventListener(new ValueEventListener(){
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.exists()) {
                                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                                        {
                                            if (dataSnapshot1.exists())
                                            {
                                                foodconst fc = dataSnapshot1.getValue(foodconst.class);
                                                snapshotListData.add(fc);
                                                adapterFood.notifyDataSetChanged();
                                            }
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) { }
                            });
                        }
                        else if (selectedItems[4] == true )
                        {
                            FirebaseDatabase.getInstance().getReference().child("gout").child("avoided").child("others").addValueEventListener(new ValueEventListener(){
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.exists()) {
                                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                                        {
                                            if (dataSnapshot1.exists())
                                            {
                                                foodconst fc = dataSnapshot1.getValue(foodconst.class);
                                                snapshotListData.add(fc);
                                                adapterFood.notifyDataSetChanged();
                                            }
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) { }
                            });
                        }

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.show();
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



