package com.example.myapplicationphotoeditor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;

public class ResultActivity extends AppCompatActivity {

    ImageView imageView,back_btn,home_btn,share_btn,fb_btn,wh_btn,insta_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        imageView=findViewById(R.id.imageView);
        back_btn=findViewById(R.id.back_btn);
        home_btn=findViewById(R.id.home_btn);
        share_btn=findViewById(R.id.share_btn);
        fb_btn=findViewById(R.id.fb_btn);
        wh_btn=findViewById(R.id.wh_btn);
        insta_btn=findViewById(R.id.insta_btn);
        Uri imageuri=getIntent().getData();
        imageView.setImageURI(imageuri);
        Toast.makeText(this, "Image is Saved...", Toast.LENGTH_SHORT).show();

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent sharingintent = new Intent(Intent.ACTION_SEND);
                    sharingintent.setType("image/jpg");
                    sharingintent.putExtra(Intent.EXTRA_STREAM, imageuri);
                    sharingintent.putExtra(Intent.EXTRA_TEXT, "PlayStore Link : https://play.google.com/store/apps/details?id=" + getPackageName());
                    startActivity(sharingintent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        fb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingintent=new Intent(Intent.ACTION_SEND);
                sharingintent.setType("image/jpg");
                sharingintent.putExtra(Intent.EXTRA_STREAM,imageuri);
                sharingintent.putExtra(Intent.EXTRA_TEXT,"PlayStore Link : https://play.google.com/store/apps/details?id="+getPackageName());
                sharingintent.setPackage("com.facebook.katana");
                startActivity(sharingintent);

            }
        });
        wh_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingintent=new Intent(Intent.ACTION_SEND);
                sharingintent.setType("image/jpg");
                sharingintent.putExtra(Intent.EXTRA_STREAM,imageuri);
                sharingintent.putExtra(Intent.EXTRA_TEXT,"PlayStore Link : https://play.google.com/store/apps/details?id="+getPackageName());
                sharingintent.setPackage("com.whatsapp");
                startActivity(sharingintent);

            }
        });
        insta_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingintent=new Intent(Intent.ACTION_SEND);
                sharingintent.setType("image/jpg");
                sharingintent.putExtra(Intent.EXTRA_STREAM,imageuri);
                sharingintent.putExtra(Intent.EXTRA_TEXT,"PlayStore Link : https://play.google.com/store/apps/details?id="+getPackageName());
                sharingintent.setPackage("com.instagram.android");
                startActivity(sharingintent);

            }
        });

    }

}