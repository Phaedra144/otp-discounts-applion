package com.szilvi.applion.otp.otpdiscounts.model;

import com.szilvi.applion.otp.otpdiscounts.response.OfferResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Offer {

    int id;
    LocalDateTime endTime;
    String title;
    String subTitle;
    String partnerName;
    String description;
    String state;

}
