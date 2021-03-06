package com.example.foodrecommendation;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;


public class avoideddiabetes extends AppCompatActivity {


    Button button;
    ListView lv;
    String[] listItems;

    FirebaseListAdapter adapter;
    FoodAdapter adapterFood;
    private DatabaseReference query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avoideddiabetes);

        final ArrayList<foodconst> snapshotListData =  new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("diabetes").child("avoided").addValueEventListener(new ValueEventListener(){
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
                listItems = new String[]{"Vegetable", "Fat", "Sugar"};
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(avoideddiabetes.this);
                mBuilder.setTitle("Diabetes: avoided food");
                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        if (i == 0)
                        {
                            Intent j = new Intent(avoideddiabetes.this,avoideddiabetesvegetables.class);
                            startActivity(j);
                        }

                        if (i == 1)
                        {

                            Intent j = new Intent(avoideddiabetes.this,avoideddiabetesfat.class);
                            startActivity(j);
                        }
                        if (i == 2)
                        {

                            Intent j = new Intent(avoideddiabetes.this,avoideddiabetessugar.class);
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



