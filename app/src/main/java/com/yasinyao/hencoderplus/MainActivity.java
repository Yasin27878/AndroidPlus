package com.yasinyao.hencoderplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.yasinyao.hencoderplus.Draw.DrawActivity;
import com.yasinyao.hencoderplus.retrofit.GithubService;
import com.yasinyao.hencoderplus.retrofit.Repo;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initOkHttp();
            }
        });
    }

    private void initRetrofit() {
        Gson gson = new Gson();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        GithubService githubService = retrofit.create(GithubService.class);

        githubService.getRepo("yasin27878").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                Log.d(TAG, "onResponse:" + gson.toJson(response.body()));

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure:" + gson.toJson(t));

            }
        });

    }

    private void initOkHttp() {

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("http://api.github.com/users/rengwuxian/repo")
                .build();
        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.d(TAG, "onFailure: ");

            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: ");
            }
        });


    }

    public void startDraw(View view) {
        Intent intent = new Intent(this, DrawActivity.class);
        startActivity(intent);
    }
}