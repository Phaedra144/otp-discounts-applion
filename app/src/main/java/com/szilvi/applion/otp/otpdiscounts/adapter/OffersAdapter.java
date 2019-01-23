package com.szilvi.applion.otp.otpdiscounts.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.szilvi.applion.otp.otpdiscounts.R;
import com.szilvi.applion.otp.otpdiscounts.model.Offer;

import java.util.ArrayList;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.OffersAdepterViewHolder> {

    ArrayList<Offer> offers;
    Context context;

    public OffersAdapter(ArrayList<Offer> offers, Context context) {
        this.offers = offers;
        this.context = context;
    }

    @NonNull
    @Override
    public OffersAdepterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_offfer, viewGroup, false);
//        view.setOnClickListener((View v) -> {
//            Intent intent = new Intent(context, DetailedActivity.class);
//            itemPosition = recyclerView.getChildLayoutPosition(v);
//            intent.putExtra("noteId", itemPosition);
//            context.startActivity(intent);
//        });
        return new OffersAdepterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OffersAdepterViewHolder viewHolder, int i) {
        viewHolder.partner.setText(offers.get(i).getPartnerName());
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    class OffersAdepterViewHolder extends RecyclerView.ViewHolder {
        public TextView partner;
        public ImageView logo;
        public OffersAdepterViewHolder(View v) {
            super(v);
            partner = v.findViewById(R.id.partnerTextView);
            logo = v.findViewById(R.id.logoImage);
        }
    }
}
