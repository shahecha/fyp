package com.example.foodrecommendation;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.core.Context;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Tipsbp extends AppCompatActivity {


    Button down;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipsbp);

        down = findViewById(R.id.saveBtn);

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                download();
            }
        });
    }


    public void download()
    {

        storageReference=firebaseStorage.getInstance().getReference();
        ref=storageReference.child("Hypertension Tips.png");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener< Uri >() {
            @Override
            public void onSuccess(Uri uri) {
                String url=uri.toString();
                downloadFile(Tipsbp.this,"Hypertension Tips","png", ContactsContract.DIRECTORY_PARAM_KEY,url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }

    public void downloadFile(Tipsbp context, String fileName, String fileExtension, String destinationDirectory, String url)
    {

        DownloadManager downloadManager = (DownloadManager) context.
                getSystemService(Tipscholestrol.DOWNLOAD_SERVICE);
        Uri uri=Uri.parse(url);
        DownloadManager.Request request=new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName +fileExtension);

        downloadManager.enqueue(request);



    }

    private class DOWNLOAD_SERVICE {
    }
}
