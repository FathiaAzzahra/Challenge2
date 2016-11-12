package com.example.fathia.challenge2;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img_show;
    Button btn_gallery;
    Uri imageUri;
    private static final int PICK_IMAGE=100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btn_gallery = (Button)findViewById(R.id.btn_gallery);
    img_show = (ImageView)findViewById(R.id.img_show);

     btn_gallery.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             openGallery();
         }
     });

    }
private void openGallery() {
    Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
    startActivityForResult(gallery,PICK_IMAGE);
    }
   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
   {
       super.onActivityResult(requestCode,resultCode,data);
       if (resultCode == RESULT_OK && requestCode == PICK_IMAGE)
       {
           imageUri = data.getData();
           img_show.setImageURI(imageUri);
       }
   }
    
}
