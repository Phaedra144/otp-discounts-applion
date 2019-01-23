package com.szilvi.applion.otp.otpdiscounts.network;

import com.szilvi.applion.otp.otpdiscounts.response.OfferResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DiscountsApi {

    @GET(" ")
    Call<OfferResponse> getOffers();

}
