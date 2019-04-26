package com.mikeescom.dineout.ui.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mikeescom.dineout.R;
import com.mikeescom.dineout.ui.adapters.CollectionPagerAdapter;

public class HomeActivity extends AppCompatActivity {

    CollectionPagerAdapter collectionPagerAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        collectionPagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.home_pager);
        viewPager.setAdapter(collectionPagerAdapter);
    }
}
