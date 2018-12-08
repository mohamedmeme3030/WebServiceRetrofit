package com.example.mohamedmeme.webserviceretrofit.API;

import com.example.mohamedmeme.webserviceretrofit.Flower;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppServiceFlowerApi {

    @GET("feeds/flowers.json")
    //Determine the return of the method Call
    Call<ArrayList<Flower>> getFlowers();

}
