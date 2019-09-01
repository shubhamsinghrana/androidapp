package com.example.startuppunjab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class shownotification extends AppCompatActivity {
    ArrayList<String> content, date, id,head;
    shownotification.myhelperclass obj;
    ListView mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shownotification);
    mylist=findViewById(R.id.listmy2);
        setTitle("Latest News");
        content = new ArrayList<>();
        date = new ArrayList<>();
        id = new ArrayList<>();
        head=new ArrayList<>();
        obj = new shownotification.myhelperclass(this, android.R.layout.simple_list_item_1, content);
        mylist.setAdapter(obj);

        content.add("heading");
        date.add("heading 30 linesqwertyuiop[asdfghjkl;zxcvbnm,wertyuiop[asdfghjkl;zxcvbnm,.");
        id.add("https://www.javatpoint.com/android-webview-example");
        head.add("heading is here");
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                final AlertDialog.Builder mybuilder=new AlertDialog.Builder(shownotification.this);
                mybuilder.setMessage(head.get(i)+"\n\n"+date.get(i));
                AlertDialog mydialog=mybuilder.create();
                mydialog.show();
            }
        });

    }

    private class myhelperclass extends ArrayAdapter<String> {

        public myhelperclass(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
            super(context, resource, objects);
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View myrow = getLayoutInflater().inflate(R.layout.myyy1, parent, false);
            TextView t1, t2,t3;
            t1 = myrow.findViewById(R.id.timedate1);
            t2 = myrow.findViewById(R.id.dumtext1);
            t3=myrow.findViewById(R.id.dumtext);
            t1.setText(content.get(position));
            t2.setText(date.get(position));
            t3.setText(head.get(position));

            return myrow;

        }


    }
}