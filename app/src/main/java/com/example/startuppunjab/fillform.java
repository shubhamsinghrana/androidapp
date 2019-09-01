package com.example.startuppunjab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class fillform extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillform);
        spinner=findViewById(R.id.slumname) ;
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
    }
}
