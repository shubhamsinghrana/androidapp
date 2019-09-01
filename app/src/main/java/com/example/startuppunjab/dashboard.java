package com.example.startuppunjab;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class dashboard extends AppCompatActivity {


    LinearLayout l1,l2,l3,l4,l5;
    ImageView img;
    String d,d2,d3,d5,d4;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        l1=findViewById(R.id.newsid);
        l2=findViewById(R.id.l2);
        l3=findViewById(R.id.l3);
        t1=findViewById(R.id.titleMedium);
        l4=findViewById(R.id.itemSlid1);
        l5=findViewById(R.id.itemSlid);
        img=findViewById(R.id.signout);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            d= (String) b.get("email");
            d2=(String) b.get("date");
            d3=(String) b.get("employees");
            d4=(String) b.get("industry");
            d5=(String) b.get("rank");
            // Toast.makeText(this, (String) b.get("id"), Toast.LENGTH_SHORT).show();
        }
        t1.setText(d);
        //Toast.makeText(this, d2, Toast.LENGTH_SHORT).show();
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
                i.putExtra("email", d);
                i.putExtra("date",d2 );
                i.putExtra("employees",d3 );
                i.putExtra("industry",d4 );
                i.putExtra("rank",d5 );
                startActivity(i);
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
