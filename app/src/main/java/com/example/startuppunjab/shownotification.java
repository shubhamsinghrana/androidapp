package com.example.startuppunjab;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class shownotification extends AppCompatActivity {
    ArrayList<String> content, id,head;
    shownotification.myhelperclass obj;
    ListView mylist;
    String t;
    String mMessage;
    public static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shownotification);
    mylist=findViewById(R.id.listmy2);
        setTitle("Government Updates");
        content = new ArrayList<>();
        id = new ArrayList<>();
        head=new ArrayList<>();
        OkHttpClient client = new OkHttpClient();

            JSONObject postdata = new JSONObject();
            try {
                postdata.put("email","123");

            } catch(JSONException e){
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());
        String url = "http://146.148.48.62:5001/api/notification";
        // Toast.makeText(login.this, url, Toast.LENGTH_SHORT).show();
        Request request = new Request.Builder()
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .url(url)
                .build();
        //Toast.makeText(login.this, request.toString(), Toast.LENGTH_SHORT).show();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage().toString();
                Log.w("failure Response", mMessage);
                t=mMessage;
                //Toast.makeText(login.this, "Unable to connect", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                 mMessage = response.body().string();
                Log.w("Response",mMessage);
                fetchvalue();

                    try {

                        JSONArray jsonA= new JSONArray(mMessage);
                        for(int n=0;n<jsonA.length();n++) {
                            JSONObject json = jsonA.getJSONObject(n);
                           // Toast.makeText(shownotification.this, json.getString("id"), Toast.LENGTH_SHORT).show();
                            id.add(json.getString("id"));
                            content.add(json.getString("content"));
                            head.add(json.getString("title"));

                        }
                        obj.notifyDataSetChanged();
                        }


                    catch (Exception e){
                        e.printStackTrace();
                    }



                // Toast.makeText(login.this, response.body().toString(), Toast.LENGTH_SHORT).show();
            }

        });



        obj = new shownotification.myhelperclass(this, android.R.layout.simple_list_item_1, content);

        mylist.setAdapter(obj);

        //Toast.makeText(this, head.get(0), Toast.LENGTH_SHORT).show();
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                final AlertDialog.Builder mybuilder=new AlertDialog.Builder(shownotification.this);
                mybuilder.setMessage(head.get(i)+"\n\n"+content.get(i));
                AlertDialog mydialog=mybuilder.create();
                mydialog.show();
                //oast.makeText(shownotification.this, mMessage, Toast.LENGTH_SHORT).show();

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
            t1 = myrow.findViewById(R.id.dumtext);

            t3=myrow.findViewById(R.id.timedate1);
            t1.setText(content.get(position));
            t3.setText(head.get(position));

            return myrow;

        }


    }
    void fetchvalue()
    {

        try {

            Toast.makeText(this, mMessage, Toast.LENGTH_SHORT).show();

            JSONArray jsonA= new JSONArray(mMessage);
            for(int n=0;n<jsonA.length();n++) {
                JSONObject json = jsonA.getJSONObject(n);
                Toast.makeText(shownotification.this, json.getString("id"), Toast.LENGTH_SHORT).show();

                id.add(json.getString("id"));

                content.add(json.getString("content"));
                head.add(json.getString("Title"));
                Toast.makeText(this, json.getString("Title"), Toast.LENGTH_SHORT).show();
            }
            obj.notifyDataSetChanged();
        }


        catch (Exception e){
            e.printStackTrace();
        }

    }


}