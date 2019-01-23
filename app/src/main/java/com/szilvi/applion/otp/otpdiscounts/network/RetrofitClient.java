package com.szilvi.applion.otp.otpdiscounts.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String BASE_URL_BACKEND = "http://www.mocky.io/v2/593284a40f0000b0175bfc31/";

    private static Retrofit getConnection(String urlType) {
        return new Retrofit.Builder()
                .baseUrl(urlType)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
    }

    public static DiscountsApi getDiscountsApi() {
        return getConnection(BASE_URL_BACKEND).create(DiscountsApi.class);
    }
}
