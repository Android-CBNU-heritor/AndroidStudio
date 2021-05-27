package com.example.foodmart1.Controller;

import com.example.foodmart1.Store.Store;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StoreController {

    public String BaseUrl = "10.0.2.2";
    public String Port = "8080";
    private Retrofit retrofit;
    private StoreApi storeApi;

    public String Downloadurl = "http://" + BaseUrl + ":" + Port + "/downloadImage/";

    List<Store> stores;

    private static StoreController single_instance = null;

    public static StoreController getInstance() {
        if (single_instance == null) {
            single_instance = new StoreController();
        }
        return single_instance;
    }

    public StoreApi changer() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://" + BaseUrl + ":" + Port)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        storeApi = retrofit.create(StoreApi.class);
        return storeApi;
    }


}
