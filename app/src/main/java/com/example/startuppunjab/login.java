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
    String s="success";
    public static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
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
                //Toast.makeText(login.this,body.toString(), Toast.LENGTH_SHORT).show();
                OkHttpClient client = new OkHttpClient();

                String url = "http://146.148.48.62:5001/api/login";
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
                        //Toast.makeText(login.this, "Unable to connect", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        String mMessage = response.body().string();
                        Log.w("Response",mMessage);
                        if (response.isSuccessful()){
                            Log.w("Response",mMessage);
                            try {
                                JSONObject json = new JSONObject(mMessage);
                                final String serverResponse = json.getString("status");
                                String s1=json.getString("name");
                                String s2=json.getString("date");
                                String s3=json.getString("employees");
                                String s4=json.getString("industry");
                                String s5=json.getString("rank");
                                //Toast.makeText(login.this, serverResponse, Toast.LENGTH_SHORT).show();
                                if(serverResponse=="true"){

                                Intent i = new Intent(login.this,
                                        dashboard.class);
                                    i.putExtra("email", s1);
                                    i.putExtra("date",s2 );
                                    i.putExtra("employees",s3 );
                                    i.putExtra("industry",s4 );
                                    i.putExtra("rank",s5 );
                                startActivity(i);
                                login.this.finish();}
                                else if(serverResponse=="false")
                                {
                                    s="wrong password";
                                   //Toast.makeText(login.this, "Invalid Email/Password", Toast.LENGTH_SHORT).show();
                                }
                                else if(serverResponse==null)
                                {
                                    s="error in connection";
                                   // Toast.makeText(login.this, "Email not registered.", Toast.LENGTH_SHORT).show();
                                }
                                else
                                    Toast.makeText(login.this, "Not Working", Toast.LENGTH_SHORT).show();
                            } catch (Exception e){
                                e.printStackTrace();
                            }

                        }

                       // Toast.makeText(login.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                    }

                });
              // Toast.makeText(login.this, s, Toast.LENGTH_SHORT).show();


            }
        });
    }
}
