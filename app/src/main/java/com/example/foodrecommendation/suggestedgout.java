package com.example.foodrecommendation;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;


public class suggestedgout extends AppCompatActivity {

    Button button;
    ListView lv;
    FirebaseListAdapter adapter;

    CharSequence[] items={"Grains","Fruits","Vegetable","Animal source food","Nuts","Fats"};
    boolean[] selectedItems={false,false,false,false,false,false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(suggestedgout.this);
                alertDialogBuilder.setCancelable(true);
                alertDialogBuilder.setTitle("Select Food Category");
                alertDialogBuilder.setMultiChoiceItems(items, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        selectedItems[which]=isChecked;
                    }
                });
                alertDialogBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //letak coding retrieve yang filter
                        if (selectedItems[0]==true && selectedItems[1]==true)
                        {
                            /*Intent j = new Intent(suggestedgout.this,Tips.class);
                            startActivity(j); */}
                        else if (selectedItems[1]==true)
                        {

                            /* lv=(ListView)findViewById(R.id.listView);

                            Query query = FirebaseDatabase.getInstance().getReference().child("gout");
                            FirebaseListOptions<foodconst>options=new FirebaseListOptions.Builder<foodconst>()
                                    .setLayout(R.layout.fooddetails)
                                    .setQuery(query,foodconst.class)
                                    .build();
                            adapter = new FirebaseListAdapter(options) {
                                @Override
                                protected void populateView(@NonNull View v, @NonNull Object model, int position) {
                                    TextView title= v.findViewById(R.id.title);
                                    TextView desc=v.findViewById(R.id.desc);
                                    ImageView image=v.findViewById(R.id.imageView);


                                    foodconst fc=(foodconst)model;
                                    title.setText("Title:"+fc.getTitle());
                                    desc.setText("Decsription:"+fc.getDesc());
                                    Picasso.get().load(fc.getImage()).into(image);

                                }
                            }; lv.setAdapter(adapter); */
                        }



                    }
                });
                AlertDialog alertDialog=alertDialogBuilder.create();
                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.show();

            }
        });


        Query query = FirebaseDatabase.getInstance().getReference().child("gout");
        Query query1=query.orderByChild("suggested");

        /*query1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i(TAG, dataSnapshot.child("title").getValue(foodconst.class));
                Log.i(TAG, dataSnapshot.child("desc").getValue(foodconst.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG,"onCancelled", databaseError.toException());

            }
        });*/


        final FirebaseListOptions<foodconst>options=new FirebaseListOptions.Builder<foodconst>()
                .setLayout(R.layout.fooddetails)
                .setQuery(query,foodconst.class)
                .build();

        lv=(ListView)findViewById(R.id.listView);


        adapter =new FirebaseListAdapter(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull Object model, int position) {

                TextView title=v.findViewById(R.id.title);
                TextView desc=v.findViewById(R.id.desc);

               /* ValueEventListener eventListener=new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {


                       foodconst fc = dataSnapshot.getValue(foodconst.class);
                        title.setText("Title:"+fc.getTitle());
                        desc.setText("Decsription:"+fc.getDesc());
                          Log.d("TAG", title + " / " + desc);
                       )

                            foodconst title = ds.child("title").getValue(foodconst.class);
                            foodconst desc = ds.child("desc").getValue(foodconst.class);
                            Log.d("TAG", title + " / " + desc);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }; */




            }
        };

        lv.setAdapter(adapter);





    }
}



