package com.szilvi.applion.otp.otpdiscounts.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Offer implements Serializable {

    int id;
    String endTime;
    String title;
    String subTitle;
    String partnerName;
    String description;
    String state;
    String logoUrl;
    List<String> shops;

    public Offer(int id, String endTime, String title, String subTitle, String partnerName, String description, String state, String logoUrl, List<String> shops) {
        this.id = id;
        this.endTime = convertToNiceDateFormat(endTime);
        this.title = title;
        this.subTitle = subTitle;
        this.partnerName = partnerName;
        this.description = description;
        this.state = state;
        this.logoUrl = logoUrl;
        this.shops = shops;
    }

    public String convertToNiceDateFormat(String endTime) {
        System.out.println(endTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date parsedDate = null;
        try {
            parsedDate = simpleDateFormat.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return simpleDateFormat.format(parsedDate);
    }

    public Offer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<String> getShops() {
        return shops;
    }

    public void setShops(List<String> shops) {
        this.shops = shops;
    }


}
