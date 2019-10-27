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


public class test extends AppCompatActivity {

    Button button;
    ListView lv;
    FirebaseListAdapter adapter;
    FoodAdapter adapterFood;
    private DatabaseReference query;

    CharSequence[] items = {"Fat", "Fruits", "Vegetable", "Animal source food", "Nuts", "Grains"};
    boolean[] selectedItems = {false, false, false, false, false, false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(test.this);
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
                        //letak coding retrieve yang filter
                        if (selectedItems[0] == true) // display fat only
                        {
                            lv = (ListView) findViewById(R.id.listView);

                            final FirebaseListOptions<foodconst> options = new FirebaseListOptions.Builder<foodconst>()
                                    .setLayout(R.layout.fooddetails)
                                    .setQuery(query, foodconst.class)
                                    .build();

                            adapter = new FirebaseListAdapter(options) {
                                @Override
                                protected void populateView(@NonNull View v, @NonNull Object model, int position) {
                                    final TextView title = v.findViewById(R.id.title);
                                    final TextView desc = v.findViewById(R.id.desc);
                                    final ImageView image = v.findViewById(R.id.imageView);

                                    query.child("gout").child("suggested").child("fat").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            if (dataSnapshot.getValue() != null) {

                                                foodconst fc = dataSnapshot.getValue(foodconst.class);
                                                title.setText("Title:" + fc.getTitle());
                                                desc.setText("Decsription:" + fc.getDesc());
                                                Picasso.get().load(fc.getImage()).into(image);

                                            }

                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    lv.setAdapter(adapter);
                                }
                            };

                        } else if (selectedItems[0] == true && selectedItems[1] == true) //display fat and fruit only
                        {
                            lv = (ListView) findViewById(R.id.listView);

                            final FirebaseListOptions<foodconst> options = new FirebaseListOptions.Builder<foodconst>()
                                    .setLayout(R.layout.fooddetails)
                                    .setQuery(query, foodconst.class)
                                    .build();

                            adapter = new FirebaseListAdapter(options) {
                                @Override
                                protected void populateView(@NonNull View v, @NonNull Object model, int position) {
                                    final TextView title = v.findViewById(R.id.title);
                                    final TextView desc = v.findViewById(R.id.desc);
                                    final ImageView image = v.findViewById(R.id.imageView);

                                    query.child("gout").child("suggested").child("fat").child("fruits").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            if (dataSnapshot.getValue() != null) {

                                                foodconst fc = dataSnapshot.getValue(foodconst.class);
                                                title.setText("Title:" + fc.getTitle());
                                                desc.setText("Decsription:" + fc.getDesc());
                                                Picasso.get().load(fc.getImage()).into(image);

                                            }

                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    lv.setAdapter(adapter);
                                }
                            };
                        }

                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.show();

            }
        });
        final ArrayList<foodconst> snapshotListData =  new ArrayList<>();


        FirebaseDatabase.getInstance().getReference().child("gout").child("suggested").child("fat").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                if(dataSnapshot.exists()){
                    for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                        if(dataSnapshot1.exists()){
                            for(DataSnapshot dataSnapshot2 : dataSnapshot1.getChildren()){
                                if (dataSnapshot2.exists()) {
                                    for(DataSnapshot dataSnapshot3 : dataSnapshot2.getChildren()){
                                        if (dataSnapshot3.exists()){
                                            foodconst fc = dataSnapshot3.getValue(foodconst.class);
                                            snapshotListData.add(fc);
                                            adapterFood.notifyDataSetChanged();
                                        }

                                    }


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

        lv = (ListView) findViewById(R.id.listView);


        adapterFood = new FoodAdapter(this,0,snapshotListData);
        lv.setAdapter(adapterFood);


    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onStop() {
        super.onStop();


    }
}



