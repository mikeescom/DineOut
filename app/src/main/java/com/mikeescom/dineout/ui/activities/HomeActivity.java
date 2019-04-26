package com.mikeescom.dineout.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mikeescom.dineout.R;
import com.mikeescom.dineout.ui.adapters.CollectionPagerAdapter;

public class HomeActivity extends AppCompatActivity {

    CollectionPagerAdapter collectionPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        collectionPagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.home_pager);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager.setAdapter(collectionPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
