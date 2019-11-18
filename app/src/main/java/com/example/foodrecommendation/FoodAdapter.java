package com.example.foodrecommendation;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class FoodAdapter extends ArrayAdapter<foodconst> {
    private Activity activity;
    private ArrayList<foodconst> foods;
    private static LayoutInflater inflater = null;

    public FoodAdapter(Activity activity, int textVieweResourceId,ArrayList<foodconst> foods){
        super(activity,textVieweResourceId,foods);
        try {
            this.activity = activity;
            this.foods = foods;
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        catch (Exception e){

        }
    }
    public  int getCount(){
        return foods.size();
    }

    public long getItemId(int index){
        return index;
    }

    public  static class ViewHolder{
        public TextView title;
        public TextView desc;
        public ImageView image;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        View vi = convertView;
        final ViewHolder holder ;

        try{
            if(convertView == null){
                holder = new ViewHolder();
                vi = inflater.inflate(R.layout.fooddetails,null);
                holder.title = (TextView) vi.findViewById(R.id.title);
                holder.desc = (TextView) vi.findViewById(R.id.desc);
                holder.image = (ImageView) vi.findViewById(R.id.imageView);
                vi.setTag(holder);
            }
            else{
                holder = (ViewHolder) vi.getTag();
            }

            holder.title.setText(foods.get(position).getTitle());
            holder.desc.setText(foods.get(position).getDesc());
            Picasso.get().load(foods.get(position).getImage()).into(holder.image);
        }
        catch (Exception e){

        }
        return  vi;
    }
}