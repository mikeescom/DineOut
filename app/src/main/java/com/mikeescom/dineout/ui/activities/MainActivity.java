package com.mikeescom.dineout.ui.activities;

import android.Manifest;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mikeescom.dineout.R;
import com.mikeescom.dineout.ui.adapters.CollectionRecyclerViewAdapter;
import com.mikeescom.dineout.base.view.BaseActivity;
import com.mikeescom.dineout.presenter.DineOutPresenter;
import com.mikeescom.dineout.presenter.DineOutPresenterImpl;
import com.mikeescom.dineout.repo.DineOutRepo;
import com.mikeescom.dineout.repo.DineOutRepoImpl;
import com.mikeescom.dineout.repo.dto.City;
import com.mikeescom.dineout.repo.dto.Collection;
import com.mikeescom.dineout.repo.dto.Collections;
import com.mikeescom.dineout.repo.local.DBConstant;
import com.mikeescom.dineout.repo.local.DineOutLocalDB;
import com.mikeescom.dineout.repo.local.DineOutLocalRepo;
import com.mikeescom.dineout.repo.local.DineOutLocalRepoImpl;
import com.mikeescom.dineout.repo.remote.DineOutRemoteRepo;
import com.mikeescom.dineout.repo.remote.DineOutRemoteRepoImpl;
import com.mikeescom.dineout.ui.DineOutView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends BaseActivity<DineOutPresenter> implements DineOutView {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int REQUEST_CODE_LOCATION_PERMISSION = 101;

    private LocationManager mLocationManager;
    private Location mLocation;
    private RecyclerView recyclerViewUser;
    private TextView tvSelectedCity;
    private CollectionRecyclerViewAdapter collectionRecyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private HashMap<String, String> mCitiesIds = new HashMap<>();
    private String mSelectedCity = "";

    @Override
    protected DineOutPresenter createPresenter() {

        DineOutRemoteRepo remoteDineOutRepo = new DineOutRemoteRepoImpl();
        DineOutLocalDB localDB = Room.databaseBuilder(getApplicationContext(), DineOutLocalDB.class, DBConstant.DB_NAME)
                .fallbackToDestructiveMigration()
                .build();
        DineOutLocalRepo localDineOutRepo = new DineOutLocalRepoImpl(localDB);
        DineOutRepo dineOutRepo = new DineOutRepoImpl(remoteDineOutRepo, localDineOutRepo);

        return new DineOutPresenterImpl(dineOutRepo, AndroidSchedulers.mainThread());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSelectedCity = findViewById(R.id.selected_city);
        recyclerViewUser = findViewById(R.id.recycler_view_user);
        if(isLocationPermissionAllowed()) {
            getLocation();
        }
    }

    @Override
    public void showCities(List<City> cities) {
        Log.d(TAG, "showCities() returned: " + cities.size());
        List<String> cityNameList = new ArrayList<>();
        for (City city : cities) {
            mCitiesIds.put(city.getName(), String.valueOf(city.getId()));
            cityNameList.add(city.getName());
        }
        showSelectCityDialog(cityNameList);
        hideLoading();
    }

    private void updateSelectedCity() {
        tvSelectedCity.setText(mSelectedCity);
    }

    @Override
    public void showCollections(List<Collections> collections) {
        Log.d(TAG, "showCollections() returned: " + collections.size());
        updateSelectedCity();
        List<Collection> collectionList = new ArrayList<>();

        for (Collections collectionsObject : collections) {
            collectionList.add(collectionsObject.getCollection());
        }

        recyclerViewUser.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewUser.setLayoutManager(layoutManager);
        recyclerViewUser.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));
        collectionRecyclerViewAdapter = new CollectionRecyclerViewAdapter(getApplicationContext(), collectionList);
        recyclerViewUser.setAdapter(collectionRecyclerViewAdapter);
        hideLoading();
    }

    void getLocation() {
        if (mLocation == null) {
            try {
                mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                mLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        getPresenter().getCities("", mLocation.getLatitude(), mLocation.getLongitude(),null, 10);
    }

    private boolean isLocationPermissionAllowed() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            return true;
        }

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_LOCATION_PERMISSION);

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_LOCATION_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    // permission denied
                    Log.w(TAG, "Permission denied");
                }
                break;
        }
    }

    private void showSelectCityDialog(List<String> cityList) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(MainActivity.this);
        builderSingle.setIcon(R.drawable.dine_out_icon);
        builderSingle.setTitle("Select your city:-");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.select_dialog_singlechoice, cityList);

        builderSingle.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mSelectedCity = arrayAdapter.getItem(which);
                final int cityId = Integer.parseInt(mCitiesIds.get(mSelectedCity));
                AlertDialog.Builder builderInner = new AlertDialog.Builder(MainActivity.this);
                builderInner.setMessage(mSelectedCity);
                builderInner.setTitle("Your Selected Item is");
                builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        getPresenter().getCollections(cityId, mLocation.getLatitude(), mLocation.getLongitude() ,20);
                        dialog.dismiss();
                    }
                });
                builderInner.show();
            }
        });
        builderSingle.show();
    }

    @Override
    public void showLoading() {
        Log.d(TAG, "showLoading() returned: ");
        showProgressDialog();
    }

    @Override
    public void hideLoading() {
        Log.d(TAG, "hideLoading() returned: ");
        dismissProgressDialog();
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError() returned: " + error);
    }
}
