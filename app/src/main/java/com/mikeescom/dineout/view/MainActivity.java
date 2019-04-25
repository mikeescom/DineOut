package com.mikeescom.dineout.view;

import android.Manifest;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.mikeescom.dineout.R;
import com.mikeescom.dineout.adapter.CategoryRecyclerViewAdapter;
import com.mikeescom.dineout.base.view.BaseActivity;
import com.mikeescom.dineout.presenter.DineOutPresenter;
import com.mikeescom.dineout.presenter.DineOutPresenterImpl;
import com.mikeescom.dineout.repo.DineOutRepo;
import com.mikeescom.dineout.repo.DineOutRepoImpl;
import com.mikeescom.dineout.repo.dto.Categories;
import com.mikeescom.dineout.repo.dto.Category;
import com.mikeescom.dineout.repo.dto.City;
import com.mikeescom.dineout.repo.dto.Collections;
import com.mikeescom.dineout.repo.local.DBConstant;
import com.mikeescom.dineout.repo.local.DineOutLocalDB;
import com.mikeescom.dineout.repo.local.DineOutLocalRepo;
import com.mikeescom.dineout.repo.local.DineOutLocalRepoImpl;
import com.mikeescom.dineout.repo.remote.DineOutRemoteRepo;
import com.mikeescom.dineout.repo.remote.DineOutRemoteRepoImpl;

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
    private CategoryRecyclerViewAdapter categoryRecyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private HashMap<String, String> mCitiesIds = new HashMap<>();

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
        recyclerViewUser = findViewById(R.id.recycler_view_user);
        if(isLocationPermissionAllowed()) {
            getLocation();
        }
    }

    @Override
    public void showCategories(List<Categories> categories) {
        Log.d(TAG, "showCategories() returned: " + categories.size());
        List<Category> categoryList = new ArrayList<>();

        for (Categories categoriesObject : categories) {
            categoryList.add(categoriesObject.getCategory());
        }

        recyclerViewUser.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerViewUser.setLayoutManager(layoutManager);

        //add divider for spacing
        recyclerViewUser.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));

        // specify an adapter (see also next example)
        categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(getApplicationContext(), categoryList);
        recyclerViewUser.setAdapter(categoryRecyclerViewAdapter);
    }

    @Override
    public void showCities(List<City> cities) {
        Log.d(TAG, "showCities() returned: " + cities.size());
        List<String> cityNameList = new ArrayList<>();
        for (City city : cities) {
            mCitiesIds.put(String.valueOf(city.getId()), city.getName());
            cityNameList.add(city.getName());
        }
        showSelectCityDialog(cityNameList);
        hideLoading();
    }

    @Override
    public void showCollections(List<Collections> collections) {

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
        getPresenter().getCities("", mLocation.getLatitude(),mLocation.getLongitude(),null, 10);
    }

    private void initData() {
        getPresenter().getCategories();
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
                String strName = arrayAdapter.getItem(which);
                AlertDialog.Builder builderInner = new AlertDialog.Builder(MainActivity.this);
                builderInner.setMessage(strName);
                builderInner.setTitle("Your Selected Item is");
                builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
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
