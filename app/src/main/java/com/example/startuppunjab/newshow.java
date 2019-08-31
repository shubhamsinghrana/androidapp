package com.example.startuppunjab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class newshow extends AppCompatActivity {
String d;
    WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newshow);
        wv1=findViewById(R.id.shownews);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            d= (String) b.get("id");
        }
       // Toast.makeText(this, d, Toast.LENGTH_SHORT).show();
        wv1.loadUrl(d);


    }
}
