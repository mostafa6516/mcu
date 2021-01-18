package com.example.mcu.LocationOwner;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mcu.LocationOwner.homeData.retailer_homefragment;
import com.example.mcu.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class retailer_dashboard_Activity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_dashboard_);

        chipNavigationBar=findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_home,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new retailer_homefragment ()).commit();
        bottomMenu();
    }

    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment =null;
                switch (i){
                    case R.id.bottom_nav_home:
                        fragment = new retailer_homefragment();
                        break;
                    case R.id.bottom_nav_cost:
                        fragment = new retailer_costfragment();
                        break;
                    case R.id.bottom_nav_Setting:
                        fragment = new retailer_settingfragment();
                        break;
                    case R.id.bottom_nav_ip_Setting:
                        fragment = new retailer_ip_settingfragment();
                        case R.id.bottom_nav_profile:
                        fragment = new retailer_profile();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();

            }
        });


    }


}
