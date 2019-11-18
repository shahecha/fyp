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
import android.widget.ListView;

import android.widget.TextView;


public class Introduction extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"DIABETES","HYPERTENSION","HYPERLIPIDEMIA","GOUT"};
    int images[] = { R.drawable.diabetes, R.drawable.hbp, R.drawable.highcholestrol,R.drawable.gout};

    //radio button list
    String[] listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        listView = findViewById(R.id.listView);


        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                if (position == 0) {
                    Intent j = new Intent(Introduction.this,introdiabetes.class);
                    startActivity(j); }

                if (position == 1) {
                    Intent j = new Intent(Introduction.this,Introbp.class);
                    startActivity(j); }

                if (position == 2) {
                    Intent j = new Intent(Introduction.this,Introhc.class);
                    startActivity(j); }


                if (position == 3) {
                    Intent j = new Intent(Introduction.this,Introgout.class);
                    startActivity(j); }

            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Introduction context;
        String rTitle[];
        int rImgs[];

        MyAdapter (Introduction c, String[] title, int[] imgs) {
            super(c,R.layout.illnessdetails,R.id.textView1,title);
            this.context = c;
            this.rTitle = title;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater= (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.illnessdetails, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);


            return row;
        }
    }
}
