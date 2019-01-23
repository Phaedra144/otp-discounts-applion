package com.szilvi.applion.otp.otpdiscounts.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.szilvi.applion.otp.otpdiscounts.R;
import com.szilvi.applion.otp.otpdiscounts.activity.DetailedActivity;
import com.szilvi.applion.otp.otpdiscounts.model.Offer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.OffersAdepterViewHolder> {

    List<Offer> offers;
    Context context;
    RecyclerView recyclerView;

    public OffersAdapter(ArrayList<Offer> offers, Context context) {
        this.offers = offers;
        this.context = context;
    }

    @NonNull
    @Override
    public OffersAdepterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_offfer, viewGroup, false);
        view.setOnClickListener((View v) -> {
            Intent intent = new Intent(context, DetailedActivity.class);
            int itemPosition = recyclerView.getChildLayoutPosition(v);
            intent.putExtra("offer", offers.get(itemPosition));
            context.startActivity(intent);
        });
        return new OffersAdepterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OffersAdepterViewHolder viewHolder, int i) {
        viewHolder.partner.setText(offers.get(i).getPartnerName());
        viewHolder.title.setText(offers.get(i).getTitle());
        viewHolder.endTime.setText(offers.get(i).getEndTime());
        getImages(viewHolder, offers.get(i));
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    class OffersAdepterViewHolder extends RecyclerView.ViewHolder {
        public TextView partner;
        public TextView title;
        public TextView endTime;
        public ImageView logo;
        public OffersAdepterViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.titleText);
            partner = v.findViewById(R.id.partnerTextView);
            endTime = v.findViewById(R.id.endTme);
            logo = v.findViewById(R.id.logoImage);
        }
    }

    private void getImages(OffersAdepterViewHolder holder, Offer offer) {
        holder.logo.setImageBitmap(null);
        Picasso.get().cancelRequest(holder.logo);
        Picasso.get().load(offer.getLogoUrl()).fit().into(holder.logo);
    }
}
