package com.example.mohamedmeme.webserviceretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mohamedmeme.webserviceretrofit.API.AppServiceFlowerApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private AppServiceFlowerApi api;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_flower);
        progressBar = findViewById(R.id.loading);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://services.hanselandpetal.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(AppServiceFlowerApi.class);
        getFlowers();
    }

    private void getFlowers() {

        progressBar.setVisibility(View.VISIBLE);
        api.getFlowers().enqueue(new Callback<ArrayList<Flower>>() {
            @Override
            public void onResponse(Call<ArrayList<Flower>> call, Response<ArrayList<Flower>> response) {
                progressBar.setVisibility(View.GONE);
                if (response.body() != null && response.body().size() != 0) {
                    ArrayList<Flower> flowers = response.body();

                    AdapterFlower adapterFlower=new AdapterFlower(MainActivity.this,flowers);
                    recyclerView.setAdapter(adapterFlower);


                }
            }

            @Override
            public void onFailure(Call<ArrayList<Flower>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "Error in Connection ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
