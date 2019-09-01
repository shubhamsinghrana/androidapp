package com.example.startuppunjab;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class dashboard extends AppCompatActivity {


    LinearLayout l1,l2,l3,l4,l5;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        l1=findViewById(R.id.newsid);
        l2=findViewById(R.id.l2);
        l3=findViewById(R.id.l3);
        l4=findViewById(R.id.itemSlid1);
        l5=findViewById(R.id.itemSlid);
        img=findViewById(R.id.signout);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(dashboard.this,
                        login.class);
                startActivity(i);
                dashboard.this.finish();

            }
        });

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(dashboard.this,
                        newslist.class);
                startActivity(i);

            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(dashboard.this,
                        startuplist.class);
                startActivity(i);

            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(dashboard.this,
                        shownotification.class);
                startActivity(i);

            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(dashboard.this,
                        graphs.class);
                startActivity(i);

            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(dashboard.this,
                        fillform.class);
                startActivity(i);

            }
        });
        setTitle("");
        // requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide();

    }

}
