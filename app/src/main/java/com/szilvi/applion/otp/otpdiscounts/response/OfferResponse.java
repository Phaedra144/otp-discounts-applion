package com.szilvi.applion.otp.otpdiscounts.response;

import com.szilvi.applion.otp.otpdiscounts.model.Offer;

import java.util.List;


public class OfferResponse {

    List<Offer> offerList;

    public OfferResponse(List<Offer> offerList) {
        this.offerList = offerList;
    }

    public OfferResponse() {
    }

    public List<Offer> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<Offer> offerList) {
        this.offerList = offerList;
    }
}
