package com.szilvi.applion.otp.otpdiscounts.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.szilvi.applion.otp.otpdiscounts.R;
import com.szilvi.applion.otp.otpdiscounts.model.Offer;

import java.util.List;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        Bundle bundle = getIntent().getExtras();
        Offer offer = (Offer) bundle.getSerializable("movie");
        List<String> shops = offer.getShops();

        TextView partner = findViewById(R.id.partnerTextView2);
        TextView endTime = findViewById(R.id.endTimeTextView2);
        TextView title = findViewById(R.id.titleTexView2);
        TextView subTitle = findViewById(R.id.subTitleTextView);
        ImageView logo = findViewById(R.id.logoImage2);
        ListView listView = findViewById(R.id.shopsListView);

        partner.setText(offer.getPartnerName());
        endTime.setText(offer.getEndTime());
        title.setText(offer.getTitle());
        subTitle.setText(offer.getSubTitle());

        logo.setImageBitmap(null);
        Picasso.get().load(offer.getLogoUrl()).fit().into(logo);

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shops);
        listView.setAdapter(itemsAdapter);


    }


}
