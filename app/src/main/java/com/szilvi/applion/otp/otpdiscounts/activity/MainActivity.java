package com.szilvi.applion.otp.otpdiscounts.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.szilvi.applion.otp.otpdiscounts.R;
import com.szilvi.applion.otp.otpdiscounts.adapter.OffersAdapter;
import com.szilvi.applion.otp.otpdiscounts.model.Offer;
import com.szilvi.applion.otp.otpdiscounts.network.DiscountsApi;
import com.szilvi.applion.otp.otpdiscounts.network.RetrofitClient;
import com.szilvi.applion.otp.otpdiscounts.response.OfferResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView partner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        partner = findViewById(R.id.partnerTextView);
        requestOffers();
    }

    private void requestOffers() {
        DiscountsApi apiService = RetrofitClient.getDiscountsApi();
        Call<OfferResponse> call = apiService.getOffers();
        call.enqueue(new Callback<OfferResponse>() {
            @Override
            public void onResponse(Call<OfferResponse> call, Response<OfferResponse> response) {
                ArrayList<Offer> offers = (ArrayList<Offer>) response.body().getOfferList();
                initRecycleView(offers);
            }

            @Override
            public void onFailure(Call<OfferResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

        public void initRecycleView(ArrayList<Offer> offers) {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new OffersAdapter(offers, MainActivity.this));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}
