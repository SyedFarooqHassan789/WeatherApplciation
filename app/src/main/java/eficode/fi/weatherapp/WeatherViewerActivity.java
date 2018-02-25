package eficode.fi.weatherapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import eficode.fi.weatherapp.adapter.LocationFragmentPagerAdapter;
import eficode.fi.weatherapp.common.Extra;
import eficode.fi.weatherapp.entity.LocationInfo;

public class WeatherViewerActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_viewer);

        initializeUI();
        initializeData();
    }

    private void initializeUI() {
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.view_pager);
    }

    private void initializeData() {
        final List<LocationInfo> locationInfoList = (ArrayList<LocationInfo>) getIntent().getSerializableExtra(Extra.LOCATION_INFO_LIST);
        final LocationFragmentPagerAdapter locationFragmentPagerAdapter = new LocationFragmentPagerAdapter(getSupportFragmentManager());
        locationFragmentPagerAdapter.addAll(locationInfoList);

        viewPager.setAdapter(locationFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        final int selectedIndex = getIntent().getIntExtra(Extra.LOCATION_INFO_SELECTED_INDEX, -1);
        if (selectedIndex != -1) {
            viewPager.setCurrentItem(selectedIndex, true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
