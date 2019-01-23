package com.szilvi.applion.otp.otpdiscounts.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.szilvi.applion.otp.otpdiscounts.R;
import com.szilvi.applion.otp.otpdiscounts.network.DiscountsApi;
import com.szilvi.applion.otp.otpdiscounts.network.RetrofitClient;
import com.szilvi.applion.otp.otpdiscounts.response.OfferResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView hello = findViewById(R.id.hello);

        DiscountsApi apiService = RetrofitClient.getDiscountsApi();

        Call<OfferResponse> call = apiService.getOffers();
        call.enqueue(new Callback<OfferResponse>() {
            @Override
            public void onResponse(Call<OfferResponse> call, Response<OfferResponse> response) {
                hello.setText(response.body().getOfferList().get(0).getDescription());
            }

            @Override
            public void onFailure(Call<OfferResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
