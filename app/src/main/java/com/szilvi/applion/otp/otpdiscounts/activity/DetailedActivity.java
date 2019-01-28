package com.szilvi.applion.otp.otpdiscounts.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.szilvi.applion.otp.otpdiscounts.R;
import com.szilvi.applion.otp.otpdiscounts.adapter.ShopsAdapter;
import com.szilvi.applion.otp.otpdiscounts.fragment.MapsFragment;
import com.szilvi.applion.otp.otpdiscounts.model.Offer;

import java.util.ArrayList;
import java.util.List;

public class DetailedActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<String> shops = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        Bundle bundle = getIntent().getExtras();
        Offer offer = (Offer) bundle.getSerializable("offer");

        TextView partner = findViewById(R.id.partnerTextView2);
        TextView endTime = findViewById(R.id.endTimeTextView2);
        TextView title = findViewById(R.id.titleTexView2);
        TextView subTitle = findViewById(R.id.subTitleTextView);
        ImageView logo = findViewById(R.id.logoImage2);
        ListView listView = findViewById(R.id.shopsListView);

        try {
            shops = offer.getShops();
            partner.setText(offer.getPartnerName());
            endTime.setText(offer.convertToNiceDateFormat(offer.getEndTime()));
            title.setText(offer.getTitle());
            subTitle.setText(offer.getSubTitle());

            logo.setImageBitmap(null);
            Picasso.get().load(offer.getLogoUrl()).resize(100, 100).centerCrop().placeholder(R.drawable.otpbanklogo480).into(logo);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        if (shops == null) {
            shops = new ArrayList<>();
        }

        ShopsAdapter itemsAdapter =
                new ShopsAdapter(this, 0, (ArrayList<String>) shops);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle mapBundle = new Bundle();
        mapBundle.putString("addressSelected", shops.get(position));
        MapsFragment mapsFragment = new MapsFragment();
        mapsFragment.setArguments(mapBundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        fragmentManager.beginTransaction()
                .addToBackStack("MapsFragment")
                .replace(R.id.frameLayout, mapsFragment, "MapsFragment")
                .commit();
    }
}
