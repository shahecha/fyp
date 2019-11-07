package com.example.foodrecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tipsbp extends AppCompatActivity {

ImageView myImageView;
Button btn_save;
BitmapDrawable drawable;
Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipsbp);

        myImageView=(ImageView)findViewById(R.id.bptips);
        btn_save=(Button)findViewById(R.id.saveBtn);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawable=(BitmapDrawable)myImageView.getDrawable();
                bitmap=drawable.getBitmap();

                File sdCard= Environment.getExternalStorageDirectory();
                File directory= new File (sdCard.getAbsolutePath() + "/photoandroidstudio");
                directory.mkdir();

               /* File directory=new File("sdcard/photoalbum");

                if(!directory.exists())
                {
                    directory.mkdir();
                }*/


                String fileName= String.format("%d.jpg",System.currentTimeMillis());
                File outFile=new File(directory, fileName);


                Toast.makeText(Tipsbp.this, "Image Saved successfuly", Toast.LENGTH_SHORT).show();


                try {
                    FileOutputStream outputStream = new FileOutputStream(outFile);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100,outputStream);
                    outputStream.flush();
                    outputStream.close();


                    Intent intent= new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    intent.setData(Uri.fromFile(outFile));
                    sendBroadcast(intent);



                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });




    }

}
