package com.mikeescom.dineout.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mikeescom.dineout.R;
import com.mikeescom.dineout.ui.adapters.CollectionPagerAdapter;

public class HomeFragment extends Fragment {
    CollectionPagerAdapter collectionPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        collectionPagerAdapter = new CollectionPagerAdapter(getChildFragmentManager());
        viewPager = view.findViewById(R.id.home_pager);
        viewPager.setAdapter(collectionPagerAdapter);
        tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
