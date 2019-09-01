package com.example.startuppunjab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class newslist extends AppCompatActivity {


    ArrayList<String> content, date, id;
    newslist.myhelperclass obj;
    String j;

    ListView mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newslist);
        mylist = findViewById(R.id.mylist1);
        setTitle("Latest News");
        content = new ArrayList<>();
        date = new ArrayList<>();
        id = new ArrayList<>();
        obj = new newslist.myhelperclass(this, android.R.layout.simple_list_item_1, content);
        mylist.setAdapter(obj);

        content.add("heading");
        date.add("heading 30 linesqwertyuiop[asdfghjkl;zxcvbnm,wertyuiop[asdfghjkl;zxcvbnm,.");
        id.add("https://www.google.com");
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                Intent a = new Intent(newslist.this, newshow.class);
                a.putExtra("id", id.get(i));
                startActivity(a);


            }
        });

    }

    private class myhelperclass extends ArrayAdapter<String> {

        public myhelperclass(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
            super(context, resource, objects);
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View myrow = getLayoutInflater().inflate(R.layout.myyy, parent, false);
            TextView t1, t2;
            t1 = myrow.findViewById(R.id.timedate1);
            t2 = myrow.findViewById(R.id.dumtext1);
            t1.setText(content.get(position));
            t2.setText(date.get(position));

            return myrow;

        }


    }
}