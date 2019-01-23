package com.szilvi.applion.otp.otpdiscounts.model;

import java.time.LocalDateTime;

@Getter
public class Offer {

    int id;
    LocalDateTime endTime;
    String title;
    String subTitle;
    String partnerName;
    String description;
    String state;

}
