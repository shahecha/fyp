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


public class Illness extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"GOUT", "HYPERLIPIDEMIA", "DIABETES","HYPERTENSION" };
    int images[] = { R.drawable.gout, R.drawable.highcholestrol, R.drawable.diabetes,R.drawable.hbp};

   //radio button list
    String[] listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illness);

        listView = findViewById(R.id.listView);


        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                if (position == 0) {
                    listItems=new String[]{"Suggested food","Avoided food"};
                    AlertDialog.Builder mBuilder=new AlertDialog.Builder(Illness.this);
                    mBuilder.setTitle("Choose Food Recommendation for Gout");
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
                if (position == 1) {
                    listItems=new String[]{"Food Should be Taken","Food Should be Avoided"};
                    AlertDialog.Builder mBuilder=new AlertDialog.Builder(Illness.this);
                    mBuilder.setTitle("Choose Food Recommendation");
                    mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if(i==0)
                            { Intent j = new Intent(Illness.this,test.class);
                                startActivity(j);}
                            if(i==1)
                            { Intent j = new Intent(Illness.this,Tips.class);
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
                if (position == 2) {
                    listItems=new String[]{"Food Should be Taken","Food Should be Avoided"};
                    AlertDialog.Builder mBuilder=new AlertDialog.Builder(Illness.this);
                    mBuilder.setTitle("Choose Food Recommendation");
                    mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if(i==0)
                            { Intent j = new Intent(Illness.this,Tips.class);
                                startActivity(j);}
                            if(i==1)
                            { Intent j = new Intent(Illness.this,Tips.class);
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
                if (position == 3) {
                    listItems=new String[]{"Food Should be Taken","Food Should be Avoided"};
                    AlertDialog.Builder mBuilder=new AlertDialog.Builder(Illness.this);
                    mBuilder.setTitle("Choose Food Recommendation");
                    mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if(i==0)
                            { Intent j = new Intent(Illness.this,Tips.class);
                                startActivity(j);}
                            if(i==1)
                            { Intent j = new Intent(Illness.this,Tips.class);
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

            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Illness context;
        String rTitle[];
        int rImgs[];

        MyAdapter (Illness c, String[] title, int[] imgs) {
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
