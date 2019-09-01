package com.example.startuppunjab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class fillform extends AppCompatActivity {
    Spinner spinner;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillform);
        spinner=findViewById(R.id.slumname) ;
        b1=findViewById(R.id.savebtn);

        setTitle("");
        // requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide();
        List<String> categories = new ArrayList<String>();
        categories.add("JANUARY");
        categories.add("FEBURERY");
        categories.add("MARCH");
        categories.add("APRIL");
        categories.add("MAY");
        categories.add("JUNE");
        categories.add("JULY");
        categories.add("AUGUST");
        categories.add("SEPTEMBER");
        categories.add("OCTOBER");
        categories.add("NOVEMBER");
        categories.add("DECEMBER");
        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,categories));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(fillform.this, "Error in Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
