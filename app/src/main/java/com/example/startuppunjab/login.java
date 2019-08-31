package com.example.startuppunjab;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class login extends AppCompatActivity {
    Button login;
    EditText e1,e2;
    public static final MediaType MEDIA_TYPE = MediaType.parse("application/json");
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login);
        e1=findViewById(R.id.edittext);
        e2=findViewById(R.id.edittext2);
        setTitle("");
        // requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide();
        login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                JSONObject postdata = new JSONObject();
                try {
                    postdata.put("email", e1.getText().toString());
                    postdata.put("password", e2.getText().toString());
                } catch(JSONException e){
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());
                OkHttpClient client = new OkHttpClient();

                String url = "http://146.148.48.62:5001/api/login";
               // Toast.makeText(login.this, url, Toast.LENGTH_SHORT).show();
                Request request = new Request.Builder()
                        .post(body)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("cache-control", "no-cache")
                        .url(url)
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        String mMessage = e.getMessage().toString();
                        Log.w("failure Response", mMessage);
                        //Toast.makeText(login.this, "Unable to connect", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        String mMessage = response.body().string();
                        Log.w("Response",mMessage);
                        if (response.isSuccessful()){
                            try {
                                JSONObject json = new JSONObject(mMessage);
                                final String serverResponse = json.getString("status");
                                if(serverResponse=="True"){
                                Intent i = new Intent(login.this,
                                        dashboard.class);
                                    i.putExtra("email", e1.getText().toString());
                                startActivity(i);
                                login.this.finish();}
                            } catch (Exception e){
                                e.printStackTrace();
                            }

                        }

                       // Toast.makeText(login.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}
