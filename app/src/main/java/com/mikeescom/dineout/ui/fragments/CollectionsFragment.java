package com.mikeescom.dineout.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.mikeescom.dineout.R;
import com.mikeescom.dineout.ui.adapters.CollectionRecyclerViewAdapter;

import java.util.HashMap;

public class CollectionsFragment extends Fragment {
    private static final String TAG = CollectionsFragment.class.getSimpleName();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerViewUser;
    private CollectionRecyclerViewAdapter collectionRecyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private HashMap<String, String> mCitiesIds = new HashMap<>();

    private String mParam1;
    private String mParam2;

    public CollectionsFragment() {

    }

    public static CollectionsFragment newInstance(String param1, String param2) {
        CollectionsFragment fragment = new CollectionsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collections, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
