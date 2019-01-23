package com.szilvi.applion.otp.otpdiscounts.response;

import com.szilvi.applion.otp.otpdiscounts.model.Offer;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferResponse {

    List<Offer> offerList;

}
