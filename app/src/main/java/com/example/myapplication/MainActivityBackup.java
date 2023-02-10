package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.ui.dashboard.DashboardFragment;
import com.example.myapplication.ui.home.HomeFragment;
import com.example.myapplication.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivityBackup extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager=getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    HomeFragment homeFragment = new HomeFragment();
    NotificationsFragment notificationFragment = new NotificationsFragment();
    DashboardFragment dashboardFragment = new DashboardFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_view);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.homeLayout, homeFragment).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.navigation_home:
                        fragmentTransaction.replace(R.id.homeLayout,homeFragment).commitAllowingStateLoss();
                        break;
                    case R.id.navigation_dashboard:
                        fragmentTransaction.replace(R.id.homeLayout,dashboardFragment).commitAllowingStateLoss();
                        break;
                    case R.id.navigation_notifications:
                        fragmentTransaction.replace(R.id.homeLayout,notificationFragment).commitAllowingStateLoss();
                        break;
                }
                return false;
            }
        });
    }

}