package com.example.mcu.LocationOwner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mcu.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class retailer_dashboard_Activity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_retailer_dashboard_);
    }
}