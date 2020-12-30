package com.example.mcu.LocationOwner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.WindowManager;

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
        bottomMenu();
    }

    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

            }
        });


    }
}