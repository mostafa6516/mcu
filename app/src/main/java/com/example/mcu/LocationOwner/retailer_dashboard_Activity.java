package com.example.mcu.LocationOwner;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mcu.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class retailer_dashboard_Activity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    private Object ChipNavigationBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_dashboard_);


        ChipNavigationBar = findViewById(R.id.bottom_nav_mnue);
        //ChipNavigationBar.setItemSelected(R.id.bottom_nav_dashboard, isSelected true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new retailer_dashboardFragment()).commit();
        bottomMenu();
    }

    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.bottom_nav_home:
                        fragment = new retailer_dashboardFragment();
                    case R.id.bottom_nav_cost:
                        fragment = new retailer_manageFragment();
                    case R.id.bottom_nav_Setting:
                        fragment = new retailer_profileFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });


    }
}