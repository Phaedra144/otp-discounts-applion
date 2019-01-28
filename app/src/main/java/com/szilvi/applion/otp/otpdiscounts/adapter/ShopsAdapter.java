package com.szilvi.applion.otp.otpdiscounts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.szilvi.applion.otp.otpdiscounts.R;
import com.szilvi.applion.otp.otpdiscounts.model.Offer;

import java.util.ArrayList;
import java.util.List;

public class ShopsAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<String> shops;


    public ShopsAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.shops = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_list_item, parent, false);

        String addressStr = shops.get(position);
        TextView addressTxt = view.findViewById(R.id.addressListText);
        addressTxt.setText(addressStr);
        return view;
    }

}
